//package com.example.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http
//            // CSRF disable (Postman / React use)
//            .csrf(csrf -> csrf.disable())
//
//            // Authorization rules
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers(
//                        "/students/**",
//                        "/staff/**",
//                        "/api/admin/login"
//                ).permitAll()
//                .anyRequest().authenticated()
//            )
//
//            // Disable default login form
//            .formLogin(form -> form.disable())
//
//            // Disable http basic popup
//            .httpBasic(basic -> basic.disable());
//
//        return http.build();
//    }
//}
