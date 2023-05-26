package com.Tryjwt.Security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {


    private final AuthenticationService service;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
        @RequestBody RegisterRequest request){
        System.out.println("Register me aaya");
        return ResponseEntity.ok(service.register(request));
    }

    @GetMapping("/getmessage")
    public String getmsg(){
        return "getting msg !!";
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request){

        return ResponseEntity.ok(service.authenticate(request));
    }
}
