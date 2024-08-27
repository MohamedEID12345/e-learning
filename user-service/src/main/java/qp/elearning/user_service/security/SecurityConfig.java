package qp.elearning.user_service.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // Enable @PreAuthorize and other method security annotations
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;

    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(jwtTokenProvider);

        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF protection
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/api/auth/**").permitAll() // Allow unauthenticated access to authentication endpoints
                                .requestMatchers("/courses").hasAnyRole("STUDENT", "TEACHER", "ADMIN") // View courses accessible by all roles
                                .requestMatchers("/courses/**").hasAnyRole("STUDENT", "TEACHER", "ADMIN") // View specific course
                                .requestMatchers("/courses/add").hasAnyRole("TEACHER", "ADMIN") // Add course endpoint
                                .requestMatchers("/courses/update/**").hasAnyRole("TEACHER", "ADMIN") // Update course endpoint
                                .requestMatchers("/courses/delete/**").hasAnyRole("TEACHER", "ADMIN") // Delete course endpoint
                                .requestMatchers("/admin/**").hasRole("ADMIN") // Admin panel access
                                .anyRequest().authenticated() // All other endpoints require authentication
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Using BCrypt for password encoding
    }
}
