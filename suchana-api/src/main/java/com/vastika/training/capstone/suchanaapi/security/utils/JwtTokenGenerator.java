package com.vastika.training.capstone.suchanaapi.security.utils;

import com.vastika.training.capstone.suchanaapi.security.transfer.JwtUserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

public class JwtTokenGenerator {
    public static final long TWO_DAY =2 *24 *60 * 60 * 1000;
    /** Generates the JWT token containing the username as subject, userID and role as addditional claims
     * Taken from the user and the token validity is infinite
     */



   public static String generateToken(JwtUserDto u, String secret){
       final Date expirationDate = new Date(System.currentTimeMillis() + TWO_DAY);
        //to sign the token we will use the signedAlgorithm//
       SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        //we will sign our JWT with our ApiKey secret
       byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret);
       Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //
       Claims claims = Jwts.claims().setSubject(u.getUsername());
       claims.put("userId", u.getId() + "");
       claims.put("role", u.getRole());

       return Jwts.builder()
               .setClaims(claims)
               .setIssuedAt(new Date())
               .setExpiration(expirationDate)
               .signWith(signatureAlgorithm, signingKey)
               .compact();
   }

}


