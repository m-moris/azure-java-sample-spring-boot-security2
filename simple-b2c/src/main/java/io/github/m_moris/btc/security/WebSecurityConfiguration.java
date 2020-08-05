// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package io.github.m_moris.btc.security;

import com.microsoft.azure.spring.autoconfigure.b2c.AADB2COidcLoginConfigurer;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final AADB2COidcLoginConfigurer configurer;

    public WebSecurityConfiguration(AADB2COidcLoginConfigurer configurer) {
        this.configurer = configurer;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/webjars/**", "/error**").permitAll()
                .anyRequest().authenticated()
                .and()
                .apply(configurer);
    }
}