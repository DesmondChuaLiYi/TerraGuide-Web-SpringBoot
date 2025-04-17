package com.terraguide.terraguide_springboot.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "intruder_detection_events")
@Data
public class IntruderDetectionEvent {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String title;

  @Column(name = "detection_dt", nullable = false)
  private LocalDateTime detectionDt;

  @Column(name = "distance_cm", nullable = false)
  private Integer distanceCm;

  @Column(name = "image_url", nullable = false)
  private String imageUrl;

  @Column(nullable = false)
  private String location;
}
