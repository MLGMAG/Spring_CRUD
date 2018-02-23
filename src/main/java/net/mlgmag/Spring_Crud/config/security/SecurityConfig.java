package net.mlgmag.Spring_Crud.config.security;

import net.mlgmag.Spring_Crud.service.serviceImpl.User.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final UserDetailsServiceImpl userDetailsService;
//
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Autowired
//    public SecurityConfig(UserDetailsServiceImpl userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.userDetailsService = userDetailsService;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
//    }
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeRequests().antMatchers("/singUp").permitAll()
//                .and()
//                .authorizeRequests().anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/singIn")
//                .and()
//                .logout().permitAll();

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
