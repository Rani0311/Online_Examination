package com.exam.examservice.service;

import com.exam.examservice.dtos.ExamRequestDto;
import com.exam.examservice.dtos.ExamResponseDto;
import com.exam.examservice.model.Exam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ExamService {
    ExamResponseDto createExam(ExamRequestDto examRequestDto);
    List<ExamResponseDto> getAllExams();
    ExamResponseDto getExamById(Long id);
    ExamResponseDto updateExam(Long id,ExamRequestDto examRequestDto);
    String deleteExam(Long id);
    Page<ExamResponseDto> getAllExams(int size, int page,String sortBy);

}
