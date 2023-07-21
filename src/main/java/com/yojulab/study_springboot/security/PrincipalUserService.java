package com.yojulab.study_springboot.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yojulab.study_springboot.service.UsersService;

@Service
public class PrincipalUserService implements UserDetailsService{

    @Autowired
    UsersService usersService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // query select with ID
        Map dataMap = new HashMap<>();
        dataMap.put("USERNAME", username);
        Object usernameObj = username;
        Map resultMap = (Map) usersService.selectByUIDWithAuths(dataMap);

        // session 등록
        PrincipalUser principalUser = new PrincipalUser(resultMap);   // user data와 권한(arrayList형태로)까지 한꺼번에 담겨있음

        return principalUser;
    }
    
}

// PrincipalUserService는 데이터베이스를 갔다오는 부분, username(=ID) 만 받아오는 이유는 password는 해킹될 위험이 있기 때문에.