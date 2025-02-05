package com.bala.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Value("Doctor")
    private String adminUser;
    @Value("password1")
    private String adminPassword;
    @Value("ADMIN")
    private String adminRole;

    @Value("Patient")
    private String userUser;
    @Value("password2")
    private String userPassword;
    @Value("USER")
    private String userRole;
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails doctor = User.withUsername(adminUser)
                .password(passwordEncoder()
                        .encode(adminPassword))
                .roles(adminRole)
                .build();
        UserDetails patient = User.withUsername(userUser)
                .password(passwordEncoder()
                        .encode(userPassword))
                .roles(userRole)
                .build();
        return new InMemoryUserDetailsManager(doctor, patient);

    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf ->csrf.disable())
                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/get/patient").hasRole("PATIENT")
                        .requestMatchers("/patient/save").hasRole("DOCTOR")
                        .requestMatchers("/patient/update").hasRole("DOCTOR")
                        .requestMatchers("/patient/delete").hasRole("DOCTOR")
                        .requestMatchers("/patient/age/all").hasRole("DOCTOR")
                        .anyRequest().authenticated() )
                .httpBasic(withDefaults());
        return http.build();
    }
@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
}
}
