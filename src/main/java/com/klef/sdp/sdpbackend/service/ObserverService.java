package com.klef.sdp.sdpbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.sdp.sdpbackend.entity.Observer;
import com.klef.sdp.sdpbackend.repository.ObserverRepository;
import com.klef.sdp.security.JwtUtil;

@Service
public class ObserverService {

    @Autowired
    private ObserverRepository userRepo;

    @Autowired
    private JwtUtil jwtUtil;

    public String login(String username, String password) {
        Observer user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(username);
    }
}