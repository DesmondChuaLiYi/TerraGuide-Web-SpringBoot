package com.terraguide.terraguide_springboot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "mentor_program_enrollment")
@Data
public class MentorProgramEnrollment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "program_id", nullable = false)
  private MentorProgram program;

  @ManyToOne
  @JoinColumn(name = "park_guide_id", columnDefinition = "BINARY(16)", nullable = false)
  private ParkGuide parkGuide;

  @Column(name = "enrolled_dt")
  private LocalDateTime enrolledDt;

  @PrePersist
  public void prePersist() {
    this.enrolledDt = LocalDateTime.now();
  }
}
