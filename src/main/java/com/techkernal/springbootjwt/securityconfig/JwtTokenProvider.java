package com.techkernal.springbootjwt.securityconfig;

import com.techkernal.springbootjwt.exception.APIException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;

import java.util.Date;

@Configuration
public class JwtTokenProvider {

    public String generateToken(Authentication authentication){

        String email = authentication.getName();
        Date currentTime = new Date();
        Date expirationTime = new Date(currentTime.getTime()+3600000);
        String token = Jwts.builder()
                .setSubject(email)
                .setIssuedAt(currentTime)
                .setExpiration(expirationTime)
                .signWith(SignatureAlgorithm.HS256,"secret")
                .compact();
        return token;
    }

    public String getEmailFromToken(String token){
        String email = Jwts.parser().setSigningKey("secret")
                .parseClaimsJws(token)
                .getBody().getSubject();
        return email;
    }

    boolean validateToken(String token) throws APIException {
        try {
            Jwts.parser().setSigningKey("secret")
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            throw new APIException(e.getMessage());
        }
    }


}
