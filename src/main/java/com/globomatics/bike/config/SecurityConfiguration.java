package com.globomatics.bike.config;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity   // tells spring to enable web security and below is how we secure the app
@Configuration   // tells spring that this is a config class , it will start at the start of the container
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value(value = "${autho.apiAudience}")
    private String  apiAudience;
    @Value(value = "${auth0.issuer}")
    private String issuer;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtWebSecurityConfigurer
                .forRS256(apiAudience, issuer)
                .configure(http)
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/app/bikes").permitAll()
                .antMatchers(HttpMethod.GET, "app/bikes").hasAuthority("view:registrations")
                .antMatchers(HttpMethod.GET, "app/bikes/**").hasAuthority("view:registration")
                .anyRequest().authenticated();
    }


}
