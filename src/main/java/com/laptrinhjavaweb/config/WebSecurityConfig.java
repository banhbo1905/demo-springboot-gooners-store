package com.laptrinhjavaweb.config;
//
//import com.laptrinhjavaweb.security.CustomSuccessHandler;
//import com.laptrinhjavaweb.service.impl.CustomUserDetailService;
//import jakarta.servlet.DispatcherType;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig {
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new CustomUserDetailService();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService());
//        authProvider.setPasswordEncoder(passwordEncoder());
//        return authProvider;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
//        return authConfig.getAuthenticationManager();
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/").permitAll()
//                        .requestMatchers("/admin/**").hasRole("ADMIN").
//                        anyRequest().authenticated())
////                        .requestMatchers("/**").hasRole("USER")
////                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
////                        .anyRequest().permitAll())
//
//                .formLogin(form -> form.loginPage("/login").permitAll().loginProcessingUrl("/login")
//                        .successHandler(myAuthenticationSuccessHandler()).failureUrl("/login?incorrectAccount"))
//                .logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll())
//                .exceptionHandling(exception -> exception.accessDeniedPage("/login?accessDenied"))
//                .sessionManagement(session -> session.maximumSessions(4).expiredUrl("/login?sessionTimeout"));
////        http.authenticationProvider(authenticationProvider());
//        return http.build();
//    }
//
//    @Bean
//    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
//        return new CustomSuccessHandler();
//    }
//
//}
//
//

import com.laptrinhjavaweb.security.CustomSuccessHandler;

import com.laptrinhjavaweb.service.impl.CustomUserDetailsService;
import jakarta.servlet.DispatcherType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    CustomSuccessHandler customSuccessHandler;
    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }


//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http.csrf(c -> c.disable())
//
//                .authorizeHttpRequests(request -> request.requestMatchers("/admin/**")
//                        .hasAuthority("ADMIN")
//                        .requestMatchers("/*").hasAuthority("USER")
////                        .requestMatchers("/registration", "/css/**").permitAll()
//                        .anyRequest().authenticated())
//
////                .formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login")
////                        .successHandler(customSuccessHandler).permitAll())
////
////                .logout(form -> form.invalidateHttpSession(true).clearAuthentication(true)
////                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
////                        .logoutSuccessUrl("/login?logout").permitAll());
//
//
//
//        return http.build();
//
//    }
//
//    @Autowired
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize.requestMatchers("/admin/**").hasRole("ADMIN")
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .anyRequest().permitAll())
                .formLogin(form -> form.loginPage("/login").permitAll().loginProcessingUrl("/login")
                        .successHandler(myAuthenticationSuccessHandler()).failureUrl("/login?incorrectAccount"))
                .logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll())
                .exceptionHandling(exception -> exception.accessDeniedPage("/login?accessDenied"))
                .sessionManagement(session -> session.maximumSessions(4).expiredUrl("/login?sessionTimeout"));
        http.authenticationProvider(authenticationProvider());
        return http.build();
    }

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new CustomSuccessHandler();
    }
}
