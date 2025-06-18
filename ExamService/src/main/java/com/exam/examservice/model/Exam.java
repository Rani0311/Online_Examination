package com.exam.examservice.model;
import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;
import jakarta.validation.constraints.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity


public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
    @NotBlank(message = "Title is required")
   private String title;
   @NotBlank(message = "Description is required")
   private String description;
   @NotNull(message = "Duration is required")
   @Min(value = 10,message = "Minimum duration is 10 minutes")
   private Integer duration;
   @NotNull(message = "ExamDate is Required")
   private LocalDate examDate;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }


}
/*"title": "Java Basics",
  "description": "Core Java concepts and OOP",
  "duration": 60,
  "examDate": "2025-06-01"

 */
