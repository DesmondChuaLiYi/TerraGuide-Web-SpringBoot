package com.terraguide.terraguide_springboot.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Table(name = "controllers")
@Data
public class Controller {
  @Id
  @Column(name = "user_id", columnDefinition = "BINARY(16)")
  private UUID userId;

  @Column(nullable = false)
  private String username;

  @Column(nullable = false)
  private String designation;

  @OneToOne(fetch = FetchType.LAZY)
  @MapsId
  @JoinColumn(name = "user_id")
  private User user;
}
