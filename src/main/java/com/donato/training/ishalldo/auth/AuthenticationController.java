package com.donato.training.ishalldo.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register_user")
    public ResponseEntity<AuthenticationResponse> registerAsUser(
            @RequestBody RegisterRequest registerRequest
    ){
        return ResponseEntity.ok(authenticationService.registerAsUser(registerRequest));
    }

    @PostMapping("/register_admin")
    public ResponseEntity<AuthenticationResponse> registerAsAdmin(
            @RequestBody RegisterRequest registerRequest
    ){
        return ResponseEntity.ok(authenticationService.registerAsAdmin(registerRequest));
    }

    @PostMapping("/authentication")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest authenticationRequest
    ){
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));

    }
}
