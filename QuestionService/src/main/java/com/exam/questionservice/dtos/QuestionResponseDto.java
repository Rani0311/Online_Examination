package com.exam.questionservice.dtos;

import jakarta.validation.constraints.NotBlank;

public class QuestionResponseDto {
    private Long id;
    private String message;
    private Long examId;
    private String questionText;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctOption;

    public  QuestionResponseDto(Long id,String message) {
        this.id = id;
        this.message = message;

    }

    public QuestionResponseDto(Long id, String message, Long examId, String questionText, String option1, String option2, String option3, String option4, String correctOption) {
        this.id = id;
        this.message = message;
        this.examId = examId;
        this.questionText = questionText;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctOption = correctOption;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(String correctOption) {
        this.correctOption = correctOption;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
