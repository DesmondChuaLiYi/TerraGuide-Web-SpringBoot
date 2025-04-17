package com.terraguide.terraguide_springboot.service;

import com.terraguide.terraguide_springboot.model.User;
import com.terraguide.terraguide_springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataIntegrityViolationException;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public User registerUser(User user) {
    // Check if username or email already exists
    if (userRepository.findByUsername(user.getUsername()) != null) {
      throw new IllegalArgumentException("Username already exists");
    }
    if (userRepository.findByEmail(user.getEmail()) != null) {
      throw new IllegalArgumentException("Email already exists");
    }
    // Save the user
    try{
      return userRepository.save(user);
    }catch(DataIntegrityViolationException e){
      throw new IllegalArgumentException("Error saving user: data constraint failed");
    }
  }
}
