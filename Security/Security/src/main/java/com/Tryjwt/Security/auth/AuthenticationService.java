package com.Tryjwt.Security.auth;

import com.Tryjwt.Security.Dao.UserDao;
import com.Tryjwt.Security.Model.Role;
import com.Tryjwt.Security.Model.User;
import com.Tryjwt.Security.Model.Users;
import com.Tryjwt.Security.auth.ExternalService.UsersInterface;
import com.Tryjwt.Security.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private UsersInterface usersInterface;
    private Users users;

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {

        var user= User.builder()
                .fname(request.getFname())
                .lname(request.getLname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userDao.save(user);


        var jwtToken= jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user= userDao.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken=jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
