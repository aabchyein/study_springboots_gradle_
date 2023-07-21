package com.yojulab.study_springboot.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class PrincipalUser implements UserDetails{

    Map userInfo;

    // 데이터베이스에서 가져온 정보를 넣기 위해서 생성자를 만듦
    public PrincipalUser(Map userInfo) {
        this.userInfo = userInfo;
    }

    // userInfo를 가보면 memberName이 있는데 메모리에 올라가는 것은 제한적이기 때문에 가져올 때는 get메소드로 만들어줘서 가져와야 함.(내부적으로 자바에서 사용하거나 화면에 표시할 때 get메서드를 써줘야 함)
    public String getMemberName() {
        return (String) userInfo.get("NAME");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       // 권한들
        Collection<GrantedAuthority> collections = new ArrayList<>();
        List<Map<String, Object>> resultList = (List) userInfo.get("resultList");
        for(Map item: resultList){
            collections.add(new SimpleGrantedAuthority((String) item.get("UNIQUE_ID")));
        }
        return collections;
    }

    @Override
    public String getPassword() {
        // password (메모리에 로그인한 user의 정보를 올리기 위함)
        return (String) userInfo.get("PASSWORD");
    }

    @Override
    public String getUsername() {
        // login ID (스프링에서는 username으로 사용)
        return (String) userInfo.get("UNIQUE_ID");
    }

    @Override
    public boolean isAccountNonExpired() {
        // 계정 만료 여부
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // 계정 잠길 여부
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 비밀번호 변경 기간 만료
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 휴먼 계정 여부
        return true;
    }
    
}
