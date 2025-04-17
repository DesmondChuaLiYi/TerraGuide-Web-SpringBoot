package com.terraguide.terraguide_springboot.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
public class User {
  @Id
  @Column(columnDefinition = "BINARY(16)")
  private UUID id;

  @Column(name = "firebase_uid", unique = true, nullable = false)
  private String firebaseUid;

  @Column(unique = true, nullable = false)
  private String username;

  @Column(unique = true, nullable = false)
  private String email;

  @Enumerated(EnumType.STRING)
  private Role role;

  @Column(name = "created_dt")
  private LocalDateTime createdDt;

  @PrePersist
  public void prePersist() {
    if (this.id == null) {
      this.id = UUID.randomUUID();
    }
    this.createdDt = LocalDateTime.now();
  }
}
