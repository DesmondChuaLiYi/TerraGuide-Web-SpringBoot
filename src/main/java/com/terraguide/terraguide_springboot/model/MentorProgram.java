package com.terraguide.terraguide_springboot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "mentor_programs")
@Data
public class MentorProgram {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "program_code", unique = true, nullable = false)
  private String programCode;

  @Column(name = "program_name", nullable = false)
  private String programName;

  @Column(nullable = false, columnDefinition = "TEXT")
  private String description;

  @Column(name = "image_url")
  private String imageUrl;

  @Column(nullable = false)
  private BigDecimal fees;

  @Column(name = "student_no", nullable = false)
  private Integer studentNo = 0;

  @Column(name = "average_rating")
  private BigDecimal averageRating;

  @Column(name = "instructor_name", nullable = false)
  private String instructorName;

  @Column(name = "duration_hours", nullable = false)
  private Integer durationHours;
}
