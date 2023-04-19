package com.techkernal.springbootjwt.securityconfig;

import com.techkernal.springbootjwt.exception.APIException;
import com.techkernal.springbootjwt.security.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class JwtAuthenticationFilter extends OncePerRequestFilter
{

    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private CustomUserDetailService customUserDetailService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = getToken(request);
        try {
            if(!token.isEmpty() && jwtTokenProvider.validateToken(token)){
               String email = jwtTokenProvider.getEmailFromToken(token);
               UserDetails userDetails = customUserDetailService.loadUserByUsername(email);
               UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (APIException e) {
            System.out.println(e.getMessage());
        }
    }
    private String getToken(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if(!token.isBlank() && token.startsWith("Bearer ")){
            return token.substring(7);
        }
        return null;
    }

 }
