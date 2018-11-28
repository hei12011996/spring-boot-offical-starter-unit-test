package com.oocl.web.sampleWebApp.controller;

import com.oocl.web.sampleWebApp.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

@Controller
@RequestMapping("/users")
public class UserController {

    private Long userId = 0L;

    @PostMapping(produces = {"application/json"})
    public ResponseEntity<String> create(@RequestBody User user){
        URI location = URI.create("/users/" + userId++);
        return ResponseEntity.created(location).build();
    }

}
