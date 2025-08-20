package com.alluracursos.foroHub.controller;

import com.alluracursos.foroHub.domain.user.User;
import com.alluracursos.foroHub.domain.user.UserAuthenticationData;
import com.alluracursos.foroHub.infra.security.DataJWTToken;
import com.alluracursos.foroHub.infra.security.TokenService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity userLogin(@RequestBody @Valid @NotNull UserAuthenticationData userAuthenticationData) {
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(
                    userAuthenticationData.login(),
                    userAuthenticationData.password()
            );
            var authenticatedUser = authenticationManager.authenticate(authenticationToken);
            System.out.println(authenticatedUser.getPrincipal());
            var JWTtoken = tokenService.generateToken((User) authenticatedUser.getPrincipal());
            return ResponseEntity.ok(new DataJWTToken(JWTtoken));

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid Credentials");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing the request");

        }
    }
}
