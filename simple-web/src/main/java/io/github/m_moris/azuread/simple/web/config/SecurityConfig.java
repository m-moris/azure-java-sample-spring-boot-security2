package io.github.m_moris.azuread.simple.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private ClientRegistrationRepository repo;

    public SecurityConfig(ClientRegistrationRepository repo) {
        this.repo = repo;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/webjars/**", "/error**").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                /* invalidate http session and delete cooikies when logout */
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and()
                /* enable oauth2 */
                .oauth2Login()
                .authorizationEndpoint()
                .authorizationRequestResolver(new CustomAuthorizationRequestResolver(repo));
    }
}