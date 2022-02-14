package com.tutorial.uno.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)

//public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
//
//	
//	 @Override
//	  public void configure(HttpSecurity http) throws Exception {
//		 
//		 System.out.println("enable web security");
//		 http
//         .csrf()
//         .disable()
//         .cors()
//         .and().authorizeRequests().anyRequest().permitAll();
////         .authorizeRequests().antMatchers("/api/create").permitAll()
////         .antMatchers("/api/all").permitAll()
////          .antMatchers("/api/**").permitAll(); //TODO: CAMBIAR A authenticated() cuando se solucione todo.
//	 }
//}

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().configurationSource(corsConfigurationSource())
//        .and()
//          .authorizeRequests()
//          .antMatchers("*").permitAll();
        http.cors().and().csrf().disable();
    }
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("*"));
//        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
//        configuration.setAllowedHeaders(Collections.singletonList("*"));
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
    	 CorsConfiguration configuration = new CorsConfiguration();
         configuration.setAllowedOrigins(Arrays.asList("*"));
         configuration.setAllowedMethods(Arrays.asList("*"));
         configuration.setAllowedHeaders(Arrays.asList("*"));
         configuration.setAllowCredentials(false);
         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
         source.registerCorsConfiguration("/**", configuration);
         return source;
    }
}
