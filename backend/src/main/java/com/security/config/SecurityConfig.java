package com.security.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean //1
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/").permitAll()
                //.requestMatchers("/students/all", "/students/{id}", "/students/save").hasAnyRole("USER", "ADMIN")
                  .requestMatchers( "/students/all", "/students/{id}", "/students/save").permitAll()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/users/all", "/users/save", "users/{name}").authenticated()
                .and().formLogin()
                .and()
                .httpBasic()
               .and().build();
    }


    //Custom Users -2 - only with these users, you cannot log in because you need passwordEncoder
//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//        UserDetails ADMIN = User.withUsername("mahmoud")
//                .password(passwordEncoder.encode("123"))
//                .roles("ADMIN")
//                .build();
//
//        UserDetails USER = User.withUsername("osman")
//                .password(passwordEncoder.encode("123"))
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(ADMIN, USER);
//    }


    //4 get users from the database
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserInfoUserDetailsService();
    }

    //3
    @Bean
    public PasswordEncoder PasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
