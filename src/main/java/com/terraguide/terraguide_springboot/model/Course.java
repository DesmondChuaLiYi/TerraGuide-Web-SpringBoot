package com.terraguide.terraguide_springboot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "courses")
@Data
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "course_code", unique = true, nullable = false)
  private String courseCode;

  @Column(name = "course_name", nullable = false)
  private String courseName;

  @Column(name = "course_description", nullable = false, columnDefinition = "TEXT")
  private String courseDescription;

  @Column(name = "course_image_url")
  private String courseImageUrl;

  @Column(nullable = false)
  private BigDecimal fees;

  @Column(name = "student_no", nullable = false)
  private Integer studentNo = 0;

  @Column(name = "average_rating")
  private BigDecimal averageRating;

  @Column(name = "instructor_name", nullable = false)
  private String instructorName;

  @Column(name = "duration_hours", nullable = false)
  private BigDecimal durationHours;

  @Column(name = "created_dt")
  private LocalDateTime createdDt;

  @PrePersist
  public void prePersist() {
    this.createdDt = LocalDateTime.now();
  }
}
