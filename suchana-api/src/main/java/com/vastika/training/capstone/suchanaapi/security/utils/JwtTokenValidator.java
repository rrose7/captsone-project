package com.vastika.training.capstone.suchanaapi.security.utils;

import com.vastika.training.capstone.suchanaapi.security.transfer.JwtUserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.bind.DatatypeConverter;

@Component
@Slf4j
public class JwtTokenValidator {
    @Value("${jwt.secret}")
    private String secret;


    public JwtUserDto parseToken(String token){
        JwtUserDto u = null;
        try {
            Claims body = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secret)).parseClaimsJws(token).getBody();

            u = new JwtUserDto(Integer.valueOf((String)body.get("userId")), body.getSubject(), (String) body.get("role"));

        } catch (JwtException e) {
            // Simply print the exceptions and null will be returned for the
            // userDto
            log.error("Exception while parsing token : {}", e);
        }
        return u;
    }

}

