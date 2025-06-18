package com.exam.examservice.dtos;

import java.time.LocalDate;

public class ExamResponseDto {
    private Long id;
    private String title;
    private String description;
    private Integer duration;
    private LocalDate examDate;
    private  String message;
    public ExamResponseDto(Long id, String title, String description, Integer duration, LocalDate examDate, String message) {
         this.id = id;
         this.title = title;
         this.description = description;
         this.duration = duration;
         this.examDate = examDate;
         this.message = message;
     }


    public ExamResponseDto(Long id,String message) {
         this.id = id;
         this.message = message;

     }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



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
