/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsUtils;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
	web.ignoring().antMatchers("/v2/api-docs", 
		"/configuration/ui", 
		"/swagger-resources/**",
		"/configuration/security", 
		"/swagger-ui.html", 
		"/webjars/**", 
		"/javainuse-openapi/**",
		"/database-h2/**");
	super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http.cors().and().csrf().disable().httpBasic().and().headers().cacheControl().disable().and()
		.authorizeRequests().requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
		.antMatchers("/*", 
			"/app/**", 
			"/v2/**", 
			"/swagger-ui.html", 
			"/database-h2/**").permitAll()
		.antMatchers("/admin/**").permitAll().antMatchers("/**").permitAll().anyRequest().authenticated().and();

    }

}
