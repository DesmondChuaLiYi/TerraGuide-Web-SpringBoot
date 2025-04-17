package com.terraguide.terraguide_springboot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "mentor_program_reviews")
@Data
public class MentorProgramReview {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "program_id", nullable = false)
  private MentorProgram program;

  @ManyToOne
  @JoinColumn(name = "park_guide_id", columnDefinition = "BINARY(16)", nullable = false)
  private ParkGuide parkGuide;

  @Column(nullable = false)
  private Integer rating;

  @Column(columnDefinition = "TEXT")
  private String reviewText;

  @Column(name = "created_dt")
  private LocalDateTime createdDt;

  @PrePersist
  public void prePersist() {
    this.createdDt = LocalDateTime.now();
  }
}
