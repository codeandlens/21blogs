/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.blogs.utils.JwtTokenUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    
        @Value(value = "${service-token}")
        private String tokenDefault;

        @Value(value = "${url-create-admin}")
        private String urlCreateAdmin;
        
        
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		if(!(request.getRequestURI().startsWith("/database-h2") || 
				request.getRequestURI().startsWith("/swagger") ||
				request.getRequestURI().startsWith("/webjar") ||
				request.getRequestURI().startsWith("/v2") ||
				"/".equals(request.getRequestURI()) ||
				"/csrf".equals(request.getRequestURI()) )){
			final String requestTokenHeader = request.getHeader("Authorization");
			String jwtToken = null;
			Claims decodeToken = null;
			List<String> authorities = new ArrayList<String>();
			// JWT Token is in the form "Bearer token". Remove Bearer word and get
			// only the Token
			
			//create admin by default Token
			boolean statusFirstCreate = createAdminDefaultToken(request.getRequestURI());
			
			if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
				jwtToken = requestTokenHeader.substring(7);
				try {
					decodeToken = jwtTokenUtil.getJwtJSON(jwtToken);
					Optional<Object> checkToken = Optional.ofNullable(decodeToken);
					if(checkToken.isPresent()) {
						authorities.add(decodeToken.get("role").toString());
						UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(decodeToken.get("userId"), null,
								authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
						SecurityContextHolder.getContext().setAuthentication(auth);
						chain.doFilter(request, response);
					}else {
						logger.warn("Authoriza fail");
						response.setStatus(HttpServletResponse.SC_FORBIDDEN);
					}
				} catch (IllegalArgumentException e) {
					logger.warn("Unable to get JWT Token");
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				} catch (ExpiredJwtException e) {
					logger.warn("JWT Token has expired");
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				}
			} else if (statusFirstCreate) {
			    	jwtToken = tokenDefault.substring(7);
				try {
					decodeToken = jwtTokenUtil.getJwtJSON(jwtToken);
					Optional<Object> checkToken = Optional.ofNullable(decodeToken);
					if(checkToken.isPresent()) {
						authorities.add(decodeToken.get("role").toString());
						UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(decodeToken.get("userId"), null,
								authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
						SecurityContextHolder.getContext().setAuthentication(auth);
						chain.doFilter(request, response);
					}else {
						logger.warn("Authoriza fail");
						response.setStatus(HttpServletResponse.SC_FORBIDDEN);
					}
				} catch (IllegalArgumentException e) {
					logger.warn("Unable to get JWT Token");
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				} catch (ExpiredJwtException e) {
					logger.warn("JWT Token has expired");
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				}
			} else {
				logger.warn("JWT Token does not begin with Bearer String");
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			}
		}else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @param urlCreateAdmin 
	 * @return
	 */
	private boolean createAdminDefaultToken(String urlParam) {
	    if(urlParam.contentEquals(urlCreateAdmin)) {
		return true;
	    }
	    return false;
	}

}
