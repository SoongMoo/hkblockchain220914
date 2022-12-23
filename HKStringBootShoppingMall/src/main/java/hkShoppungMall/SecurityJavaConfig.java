package hkShoppungMall;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityJavaConfig {
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) 
    		throws Exception {
		http.cors().disable() //cors방지
		.csrf().disable() //csrf방지
		.formLogin().disable()
		.headers().frameOptions().disable();
		
		
		return http.build();
	}
}
