package com.example.springbootstudent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.
                csrf((csrf)->csrf.disable())
                .authorizeHttpRequests(auth-> auth.anyRequest().authenticated())
                .formLogin(Customizer.withDefaults());
        //.httpBasic(Customizer.withDefaults());         //=> pop-up

        return http.build();
    }

    @Bean
    InMemoryUserDetailsManager userDetails(){
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();

        UserDetails yamuna = User.builder()
                .username("yamuna")
                .password(passwordEncoder().encode("yamuna"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin,yamuna);
    }
}
