package com.braga.demoProject.model;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;


@Service
public class TokenService {

    public String gerarToken(Usuario usuario){
        return JWT.create()
                .withIssuer("Clientes")
                .withSubject(usuario.getUsername())
                .withClaim("id", usuario.getId())
                .withExpiresAt(Date.from(LocalDateTime.now()
                        .plusDays(1)
                        .toInstant(ZoneOffset.of("-03:00"))))
                .sign(Algorithm.HMAC256("3F4528482B4D6251655468576D5A7134743777217A25432A46294A404E635266"));
    }

    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256("3F4528482B4D6251655468576D5A7134743777217A25432A46294A404E635266"))
                .withIssuer("Cliente")
                .build().verify(token).getSubject();

    }
}
