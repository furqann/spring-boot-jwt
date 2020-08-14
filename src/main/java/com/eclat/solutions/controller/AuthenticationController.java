package com.eclat.solutions.controller;

import com.eclat.solutions.configuration.SuperUserDetailsService;
import com.eclat.solutions.model.AuthenticationRequest;
import com.eclat.solutions.model.AuthenticationResponse;
import com.eclat.solutions.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    SuperUserDetailsService superUserDetailsService;

    @PostMapping("authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request) throws Exception {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (final BadCredentialsException e) {
            throw new Exception("Wrong Credentials", e);
        }
        final UserDetails userDetails = superUserDetailsService.loadUserByUsername(request.getUsername());
        final String jwt = new JwtUtil().generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
