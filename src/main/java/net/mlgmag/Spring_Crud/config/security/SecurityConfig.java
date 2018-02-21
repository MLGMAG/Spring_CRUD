package net.mlgmag.Spring_Crud.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
//    }
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/product/add").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/product/delete/{id}").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/product//update/{id}").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/product/list").access("hasRole('ROLE_USER')")
//
//                .antMatchers("/user/add").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/user/delete/{id}").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/user/update/{id}").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/user/list").access("hasRole('ROLE_USER')");
//
//
//    }
//}
