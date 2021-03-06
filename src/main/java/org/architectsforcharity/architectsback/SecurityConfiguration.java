package org.architectsforcharity.architectsback;

import org.architectsforcharity.architectsback.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private UserService userService;

    public SecurityConfiguration(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .httpBasic()
                .and()
                .authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()
//                .antMatchers("/event").authenticated()
//                .antMatchers("/event/**").authenticated()
//                .antMatchers("/babysitter").authenticated()
//                .antMatchers("/babysitter/**").authenticated()
//                .antMatchers("/child").authenticated()
//                .antMatchers("/child/**").authenticated()
//                .antMatchers("/location").authenticated()
//                .antMatchers("/location/**").authenticated()
//                .antMatchers("/user").permitAll()
//                .antMatchers("/login").permitAll()
//                .antMatchers("/mailer").permitAll()
//                .antMatchers("/mailer/**").permitAll()
//                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
