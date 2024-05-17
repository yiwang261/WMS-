package com.wang.WMSys.Config;


import com.wang.WMSys.Config.Filter.TokenVerifyFilter;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
public class SpringSecurityConfig {

    @Resource
    private TokenVerifyFilter tokenVerifyFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                    authorizationManagerRequestMatcherRegistry
                        .requestMatchers("/login").permitAll()
                        .anyRequest().authenticated();
                })
                .logout(logout->{
                    logout.logoutUrl("/logout");
                })
                .addFilterBefore(tokenVerifyFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }


}
