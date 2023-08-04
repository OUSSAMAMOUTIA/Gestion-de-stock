package com.example.gestion_de_stock.controller;

import com.example.gestion_de_stock.entity.Roles;
import com.example.gestion_de_stock.entity.Utilisateur;
import com.example.gestion_de_stock.repository.RolesRepository;
import com.example.gestion_de_stock.repository.UtilisateurRepository;
import com.example.gestion_de_stock.dto.auth.AuthResponseDTO;
import com.example.gestion_de_stock.service.auth.JWTGenerator;
import com.example.gestion_de_stock.dto.auth.LoginDto;
import com.example.gestion_de_stock.dto.auth.RegisterDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
@SecurityRequirement(name = "Bearer Authentication")

public class AuthController {

    private final AuthenticationProvider authenticationManager;
    private final UtilisateurRepository userRepository;
    private final RolesRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTGenerator jwtGenerator;

    @Autowired
    public AuthController(AuthenticationProvider authenticationManager, UtilisateurRepository userRepository,
                          RolesRepository roleRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        if (userRepository.findByPrenom(registerDto.getUsername()).isPresent()) {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }

        Utilisateur user = new Utilisateur();
        user.setPrenom(registerDto.getUsername());
        user.setMotDePasse(passwordEncoder.encode((registerDto.getPassword())));

        Roles roles = roleRepository.findByRoleName("USER").get();
        user.setRoles(Collections.singletonList(roles));

        userRepository.save(user);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }
}
