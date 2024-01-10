package gob.imss.necesaif.config;


import gob.imss.necesaif.config.security.JWTAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private JWTAuthorizationFilter jwtAuthorizationFilter;

//	@Autowired
	//private AppUser authUser;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
		.addFilterAfter(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class).authorizeRequests()
		.antMatchers("/healthCheck").permitAll()
		.antMatchers("/api/**").permitAll()
		.anyRequest().authenticated();

	}

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		//auth.eraseCredentials(true);
		//auth.inMemoryAuthentication().withUser(authUser.getUsername()).password("{noop}" + authUser.getPassword()).roles("USER");    
//	}
	
}
