package com.example.usertablewithhibernate.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Ivan").password("{noop}qwerty").authorities("read", "write")
                .and()
                .withUser("Boris").password("{noop}asdfg").authorities("read")
                .and()
                .withUser("Alex").password("{noop}zxcvb").authorities("write");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeRequests().antMatchers("/*/by-city").permitAll()
                .and()
                .authorizeRequests().antMatchers("/*/by-age").hasAuthority("read")
                .and()
                .authorizeRequests().antMatchers("/*/by-name-surname").hasAuthority("write")
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}