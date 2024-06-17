package mpww.helper.global.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    private String SALT = "SSAFY_JavaTrack_Project_Helper_SecretKey";
    private SecretKey secretKey = Keys.hmacShaKeyFor(SALT.getBytes(StandardCharsets.UTF_8));

    public String createToken(String id,String userNickname, String gymName){
        Date exp = new Date(System.currentTimeMillis() + 1000*60*60);
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", id);
        claims.put("userNickname", userNickname);
        claims.put("gymName", gymName);

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setClaims(claims)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public Jws<Claims> validate(String token){

        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token);
    }
    // Token에서 gymName 추출
    public String getGymNameFromToken(String token) {
        Jws<Claims> claims = Jwts.parser()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token);


        return claims.getBody().get("gymName", String.class);
    }

    public String getuserNicknameFromToken(String token) {
        Jws<Claims> claims = Jwts.parser()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token);

        return claims.getBody().get("userNickname", String.class);
    }


}
