package com.bilet.config;

import com.bilet.security.jwt.JwtSecurityConfigurer;
import com.bilet.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter {


    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    /*
    @Bean
    public  JwtTokenProvider getJwtTokenProvider(){
        return  this.jwtTokenProvider;
    }
    p */


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //@formatter:off
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/auth/signin").permitAll()
                .antMatchers(HttpMethod.GET, "/havayolu/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/havayolu/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/havayolu/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/havayolu/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/havaalani/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/havaalani/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/havaalani/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/havaalani/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/musteri/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/musteri/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/musteri/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/musteri/**").hasRole("ADMIN")

                .antMatchers(HttpMethod.POST, "/takvim/**").permitAll()
                .antMatchers(HttpMethod.GET, "/takvim/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/takvim/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/takvim/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .apply(new JwtSecurityConfigurer(jwtTokenProvider));
        //@formatter:on
    }

}
