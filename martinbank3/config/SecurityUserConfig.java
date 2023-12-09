package com.martin.egg.martinbank3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityUserConfig {
/*
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails user = User.builder()
                .username("user").password(encoder.encode("user")).authorities("read").roles("USER").build();
        UserDetails admin = User.builder()
                .username("admin").password(encoder.encode("admin")).authorities("read", "write").roles("ADMIN").build();
        UserDetails excluido = User.builder()
                .username("excluido").password(encoder.encode("excluido")).authorities("read", "write").roles("EXCLUIDO").build();
        return new InMemoryUserDetailsManager(admin, user, excluido);


    }

 */
    /*
    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();

    }
}
