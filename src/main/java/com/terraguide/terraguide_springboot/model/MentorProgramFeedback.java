package com.terraguide.terraguide_springboot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "mentor_program_feedbacks")
@Data
public class MentorProgramFeedback {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "program_id", nullable = false)
  private MentorProgram program;

  @ManyToOne
  @JoinColumn(name = "park_guide_id", columnDefinition = "BINARY(16)", nullable = false)
  private ParkGuide parkGuide;

  private Integer q1Score;
  private Integer q2Score;
  private Integer q3Score;
  private Integer q4Score;

  @Column(name = "submitted_dt")
  private LocalDateTime submittedDt;

  @PrePersist
  public void prePersist() {
    this.submittedDt = LocalDateTime.now();
  }
}
