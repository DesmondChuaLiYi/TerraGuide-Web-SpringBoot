package com.terraguide.terraguide_springboot.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Table(name = "park_guides")
@Data
public class ParkGuide {
  @Id
  @Column(name = "user_id", columnDefinition = "BINARY(16)")
  private UUID userId;

  @Column(nullable = false)
  private String username;

  @Column(columnDefinition = "TEXT")
  private String bio;

  @Column(name = "park_area", nullable = false)
  private String parkArea;

  @Column(name = "working_hours", nullable = false)
  private String workingHours;

  @Column(name = "avatar_url")
  private String avatarUrl;

  @Column(nullable = false)
  private String designation;

  @OneToOne(fetch = FetchType.LAZY)
  @MapsId
  @JoinColumn(name = "user_id")
  private User user;
}
