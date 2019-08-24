package cl.foxcorp.mov.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private MyAppUserDetailsService myAppUserDetailsService;
	
	@Autowired
	private AppAuthenticationEntryPoint appAuthenticationEntryPoint;	

	@Autowired
	@Qualifier("userService")
	private UserDetailsService userService;
		
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.authorizeRequests()
		http.csrf().disable().authorizeRequests()
			.antMatchers("/css/*", "/imgs/*").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/mov/login").loginProcessingUrl("/mov/logincheck")
			.usernameParameter("username").passwordParameter("password")
			.defaultSuccessUrl("/mov/loginsuccess").permitAll()
			.and()
			.logout().logoutUrl("/mov/logout").logoutSuccessUrl("/mov/login?logout")
			.permitAll()
			.and().httpBasic()
			.authenticationEntryPoint(appAuthenticationEntryPoint);
		/*http.csrf().disable().authorizeRequests()
	  	//.antMatchers("/user/**").hasAnyRole("ADMIN","USER")
		//.and().httpBasic().realmName("MY APP REALM")
		//.authenticationEntryPoint(appAuthenticationEntryPoint);
		.anyRequest().authenticated()
		.and().httpBasic()
		.authenticationEntryPoint(appAuthenticationEntryPoint);*/			
	}
	
    @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.userDetailsService(myAppUserDetailsService).passwordEncoder(passwordEncoder);
	}	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/mov/**");
	}	

}