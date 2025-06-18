package com.exam.examservice.mapper;

import com.exam.examservice.dtos.ExamRequestDto;
import com.exam.examservice.dtos.ExamResponseDto;
import com.exam.examservice.model.Exam;

public class ExamMapper {
    public  static Exam toExam(ExamRequestDto examRequestDto) {
        Exam exam = new Exam();
        //exam.setId(examRequestDto.getId());
        exam.setTitle(examRequestDto.getTitle());
        exam.setDescription(examRequestDto.getDescription());
        exam.setDuration(examRequestDto.getDuration());
        exam.setExamDate(examRequestDto.getExamDate());
        return exam;
    }
    public  static ExamResponseDto toExamResponseDto(Exam exam,String message) {
        return  new ExamResponseDto(exam.getId(),
                message

        );
    }


}
