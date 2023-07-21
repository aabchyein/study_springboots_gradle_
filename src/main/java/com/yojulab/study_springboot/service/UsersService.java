package com.yojulab.study_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yojulab.study_springboot.dao.SharedDao;
import com.yojulab.study_springboot.utils.Commons;

@Service
@Transactional
public class UsersService {

    @Autowired
    SharedDao sharedDao;

    @Autowired
    Commons commonUtils;

    @Autowired
    AuthsService authsService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    // 회원가입
    public Object insert(Map dataMap) {// 클라이언트가 입력한 password가 들어옴
        // password 암호화
        String password = (String) dataMap.get("password"); // SecurityConfiguration의 BCryptPasswordEncoder 메서드를 사용함
        dataMap.put("password", bCryptPasswordEncoder.encode(password));

        String sqlMapId = "Users.insert";
        Object result = sharedDao.insert(sqlMapId, dataMap);
        return result;
    }

    public Object insertWithAuths(Map dataMap){
        Object result = this.insert(dataMap);
        result = authsService.insert(dataMap);
        return result;
    }

    public Object selectByUID(Map dataMap) {
        String sqlMapId = "Users.selectByUID";

        Object result = sharedDao.getOne(sqlMapId, dataMap);
        return result;
    }

    public Object selectByUIDWithAuths(Map dataMap) {
        Map result = (Map) this.selectByUID(dataMap);
        result.putAll(authsService.selectWithUSERNAME(dataMap)); // putAll을 할 경우, 기존의 map에 key, value로 다른 값을 추가로 넣어줄 수 있음.
        return result;
    }
}