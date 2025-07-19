package com.exam.common.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.exam.user.service.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	private JwtUtil jwtUtil;
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String requestTokenHeader = request.getHeader("Authorization");
		logger.info("Token is : {} ", requestTokenHeader);

		String userName = null;
		String jwtToken = null;

		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			// Yes

			jwtToken = requestTokenHeader.substring(7);

			try {
				userName = this.jwtUtil.extractUsername(jwtToken);
			} catch (ExpiredJwtException e) {
				// TODO: handle exception
				e.printStackTrace();
				logger.info("Jwt token has expired");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("error");
			}

			// validate
			if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				final UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(userName);
				if (this.jwtUtil.validateToken(jwtToken, userDetails)) {
					// token is valid
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken= new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());

					usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(null);

				}else {
					logger.info("Token is not valid");
				}
			}

		} else {
			logger.info("Invalid token, not start with bearer string");
		}
		
		
		filterChain.doFilter(request, response);

	}

}
