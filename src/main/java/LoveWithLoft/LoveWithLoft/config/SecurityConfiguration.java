package LoveWithLoft.LoveWithLoft.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {

	private final JwtAuthenticationFilter jwtAuthFilter;
	private final AuthenticationProvider authenticationProvider;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.cors().and().csrf().disable()
				.authorizeHttpRequests()
				.requestMatchers("/api/v1/auth/**").permitAll()
				.requestMatchers("/demo-controller/**").hasAnyAuthority("PROGRAMMER")
				.requestMatchers("/users").hasAnyAuthority("ADMIN", "PROGRAMMER")
				.requestMatchers("/test").hasAnyAuthority("ADMIN", "USER")
				.requestMatchers("/profile/**").hasAnyAuthority("ADMIN", "USER")
				.requestMatchers("/produkty/**").permitAll()
				.requestMatchers("/delivery/AllDeliveries").hasAnyAuthority("ADMIN", "PROGRAMMER")
				.requestMatchers("/delivery/changeStatus").hasAnyAuthority("ADMIN", "PROGRAMMER")
				.requestMatchers("/DeliveryForEach/user").hasAnyAuthority("USER", "ADMIN", "PROGRAMMER")
				.anyRequest()
				.authenticated()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authenticationProvider(authenticationProvider)
				.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}
