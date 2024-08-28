import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorizeRequests ->
                authorizeRequests.requestMatchers("/actuator/**", "/api/policies/**").permitAll() // Allow access to /actuator and /api endpoints
                    .anyRequest().permitAll()  // Allow all requests
            )
            .csrf(AbstractHttpConfigurer::disable);  // Optionally disable CSRF protection (not recommended for production)
        
        return http.build();
    }
}