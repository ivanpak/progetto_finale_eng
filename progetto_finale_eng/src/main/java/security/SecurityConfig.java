package security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable() // Disabilita la protezione CSRF, visto che si tratta di un'API REST
                .authorizeRequests()
                .requestMatchers("/api/login").permitAll()  // Permetti l'accesso solo a /login
                .anyRequest().authenticated()  // Proteggi tutti gli altri endpoint
                .and()
                .formLogin().disable();  // Disabilita il login form-based, non necessario per le API REST

        return http.build();
    }
}