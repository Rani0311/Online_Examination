package com.exam.questionservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter

public class Question {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long examId;//will be validate later calling exam_service
    @NotBlank(message = "Question text is required")
    private String questionText;
    @NotBlank(message = "Option1 is required")
    private String option1;
    @NotBlank(message = "Option1 is required")
    private String option2;
    @NotBlank(message = "Option1 is required")
    private String option3;
    @NotBlank(message = "Option1 is required")
    private String option4;
    private String correctOption;
    /*
    "examId":1,
  "questionText":"Which of the following is a valid keyword in Java?",
  "option1":"function",
  "option2":"define",
  "option3":"implement",
  "option4":"class",
  "correctOption": "4-class"
     */
    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


}
