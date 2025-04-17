package com.terraguide.terraguide_springboot.controller;

import com.terraguide.terraguide_springboot.model.User;
import com.terraguide.terraguide_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public ResponseEntity<User> registerUser(@RequestBody User user) {
    try {
      User registeredUser = userService.registerUser(user);
      return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    } catch (IllegalArgumentException e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String handleIllegalArgumentException(IllegalArgumentException e) {
    return e.getMessage();
  }
}
