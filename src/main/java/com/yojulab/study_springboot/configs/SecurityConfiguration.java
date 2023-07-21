package com.yojulab.study_springboot.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
        public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
                // None using csrf protection
                httpSecurity.csrf().disable();
                // 권한에 대한 부분 : url & roles : user url & roles
                // url, roles from Dao
                httpSecurity.authorizeHttpRequests() // 로그인
                        .requestMatchers("/manager*").hasAnyRole("ADMIN", "MANAGER")  // 둘 중 하나의 권한만 있어도 가능
                        .requestMatchers("/admin*").hasRole("ADMIN") // admin uri는 로그인이 필요하다고 지정
                        .requestMatchers("/carInfor/map/selectSearch").authenticated()  // 로그인한 모든 사람
                        .requestMatchers("/carInfor/map/*").hasRole("USER")  // delete, update, insert를 할 수 있는 것은 로그인한 사람 중 user권한을 가지고 있는 사람
                        .anyRequest().permitAll()  // 그 외 전체 대상
                ;
                httpSecurity.formLogin(login -> login.loginPage("/loginForm")
                                .failureUrl("/loginForm?fail=true")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/")); // 자발적으로 로그인 폼에 들어갔을 때 로그인 성공 후 연결되는 화면
                httpSecurity.logout(logout -> logout
                                .logoutSuccessUrl("/main")
                                .invalidateHttpSession(true)
                                .deleteCookies("JSESSIONID"));

                // There was an unexpected error (type=Forbidden, status=403).
                // Forbidden 에러가 난 경우 홈화면으로 출력되게 해주는 방어코드
                httpSecurity.exceptionHandling()
                                .accessDeniedPage("/home");

                return httpSecurity.build();
        }
        @Bean
        public BCryptPasswordEncoder encoderPasswordEncoder() {
                return new BCryptPasswordEncoder();
        }
}

// uri에 마킹하는 부분
// admin으로 로그인 시도할 때 로그인 후 default된 화면으로 이어지면 안됨. admin페이지로 연결되어야 ㅎ는데 
// 스프링 자체에서 요청했던 부분을 기억하고 있다가 로그인 성공하면 그 해당 페이지롱 연결시켜줌.
/// admin* : uri에 admin으로 시작하는 모든 항목은 로그인이 필요하다 (*를 쓰면 모든 것을 포함함)
// 데이터베이스에는 ROLE_ 를 붙여줘야 하고 스프링에서는 roles를 굳이 붙이지 않아도 됨.(테이블 레코드에 있는 이름과 동일하게 넣어줘야 함)
// hasRole은 하나만 넣을 경우, hasAnyRole은 여러 권한을 나열할 수 있음.(전제: 데이터베이스에 있는 ROLE_)