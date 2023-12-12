package com.martin.egg.martinbank3.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers(publicEndpoints()).permitAll()
                        /*
                        .requestMatchers("/api/welcome/hellouser").hasRole("USER")
                        .requestMatchers("/api/welcome/helloadmin").hasRole("ADMIN")
                        .requestMatchers("/api/welcome/helloprotected").hasAnyRole("USER", "ADMIN")

                         */
                        .anyRequest().authenticated())
                .formLogin(withDefaults())
                .build();

    }

    private RequestMatcher publicEndpoints() {
        return new OrRequestMatcher(
                /*
                new AntPathRequestMatcher("/api//register"),
                new AntPathRequestMatcher("/api/auth/authenticate")

                new AntPathRequestMatcher("/api/greeting/hellopublic"),
*/
                new AntPathRequestMatcher("/auth/**"),
                new AntPathRequestMatcher("/swagger-ui/**"),
                new AntPathRequestMatcher("/v3/api-docs/**"),
                new AntPathRequestMatcher("/api/welcome/hellopublic"));

    }
    private RequestMatcher adminEndpoints() {

        return new AntPathRequestMatcher("/api/card/create");
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
