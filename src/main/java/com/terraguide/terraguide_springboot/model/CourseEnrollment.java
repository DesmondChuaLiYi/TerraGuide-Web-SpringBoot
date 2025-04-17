package com.terraguide.terraguide_springboot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "course_enrollment")
@Data
public class CourseEnrollment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "course_id", nullable = false)
  private Course course;

  @ManyToOne
  @JoinColumn(name = "park_guide_id", columnDefinition = "BINARY(16)", nullable = false)
  private User parkGuide;

  @Column(name = "enrolled_dt")
  private LocalDateTime enrolledDt;

  @PrePersist
  public void prePersist() {
    this.enrolledDt = LocalDateTime.now();
  }
}
