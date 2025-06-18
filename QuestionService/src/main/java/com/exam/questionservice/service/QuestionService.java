package com.exam.questionservice.service;

import com.exam.questionservice.dtos.QuestionRequestDto;
import com.exam.questionservice.dtos.QuestionResponseDto;
import com.exam.questionservice.model.Question;
import org.springframework.data.domain.Page;

import java.util.List;

public interface QuestionService {
    public QuestionResponseDto addQuestion(QuestionRequestDto questionRequestDto);
    public QuestionResponseDto getQuestionById(Long id);
   // public List<QuestionResponseDto> getAllQuestions();
    public  List<Question> getQuestionByExamId(Long examId);
    public QuestionResponseDto updateQuestion( Long id ,QuestionRequestDto questionRequestDto);
    public QuestionResponseDto deleteQuestion(Long id);
    Page<QuestionResponseDto> getALLQuestions(int size,int page,String SortBy);



}
