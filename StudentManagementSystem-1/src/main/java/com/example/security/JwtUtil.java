//package com.example.security;
//
//import java.sql.Date;
//
//import org.springframework.stereotype.Component;
//
//@Component
//public class JwtUtil {
//
// private final String SECRET = "school_secret_123456";
//
// public String generateToken(String email) {
//   return Jwts.builder()
//     .setSubject(email)
//     .setIssuedAt(new Date())
//     .setExpiration(new Date(System.currentTimeMillis()+86400000))
//     .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()), SignatureAlgorithm.HS256)
//     .compact();
// }
//}
