package com.nikki.mall.tiny.config;

import com.nikki.mall.tiny.component.JwtAuthenticationTokenFilter;
import com.nikki.mall.tiny.component.RestAuthenticationEntryPoint;
import com.nikki.mall.tiny.component.RestfulAccessDeniedHandler;
import com.nikki.mall.tiny.dao.UmsAdminRoleRelationDao;
import com.nikki.mall.tiny.dto.AdminUserDetails;
import com.nikki.mall.tiny.mbg.model.UmsAdmin;
import com.nikki.mall.tiny.mbg.model.UmsPermission;
import com.nikki.mall.tiny.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

/**
 * SpringSecurity的配置
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UmsAdminService adminService;
    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDenieHandler;
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf() //由于使用的是JWT，我们这里不需要csrf
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, //允许对网站静态资源的无授权访问
                        "/",
                        "/*.html",
                        ".favicon.ico",
                        "/**/*.css",
                        "/**/*.js",
                        "/swagger-resource/**",
                        "/v2/api-docs/**")
                .permitAll()
                .antMatchers("/admin/login","/admin/register")//对登录注册要允许匿名访问
                .permitAll()
                .antMatchers(HttpMethod.OPTIONS)//跨域请求会先进行一次options请求
                .permitAll()
                .anyRequest()//除上面外的所有请求全部需要鉴权认证
                .authenticated();
        //禁用缓存
        httpSecurity.headers().cacheControl();
        //添加JWT filter
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //添加自定义未授权和未登录结果返回
        httpSecurity.exceptionHandling()
                .accessDeniedHandler(restfulAccessDenieHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint);
    }

    @Override
    protected  void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDeatilsService())
                .passwordEncoder(passwordEncoder());
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDeatilsService(){
        //get the user info
        return username ->{
            UmsAdmin admin = adminService.getAdminByUsername(username);
            if(admin != null){
                List<UmsPermission> permissions = adminService.getPermissionList(admin.getId());
                return  new AdminUserDetails(admin,permissions);
            }
            throw  new UsernameNotFoundException("username or assword is incorrect");
        };
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
        return new JwtAuthenticationTokenFilter();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception{
        return  super.authenticationManagerBean();
    }
}
