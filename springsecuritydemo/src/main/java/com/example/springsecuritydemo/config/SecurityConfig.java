package com.example.springsecuritydemo.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 链式编程
    // 授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/*").hasRole("vip1")
                .antMatchers("/level2/*").hasRole("vip2")
                .antMatchers("/level3/*").hasRole("vip3");
        // 没有权限就默认到登录页面
        http.formLogin().loginPage("/toLogin");
        // 注销，成功后跳转到首页
        http.logout().logoutSuccessUrl("/");
        // 防止网站被攻击
        http.csrf().disable();
        // 开启记住我功能
        http.rememberMe().rememberMeParameter("remember");
    }

    // 认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("pbb").password(new BCryptPasswordEncoder().encode("111"))
                .roles("vip2")
                .and()
                .withUser("paa").password(new BCryptPasswordEncoder().encode("111"))
                .roles("vip1")
                .and()
                .withUser("pcc").password(new BCryptPasswordEncoder().encode("111"))
                .roles("vip3")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("root"))
                .roles("vip1","vip2","vip3");
    }
}
