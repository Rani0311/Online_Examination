package com.exam.questionservice.mapper;

import com.exam.questionservice.dtos.QuestionRequestDto;
import com.exam.questionservice.dtos.QuestionResponseDto;
import com.exam.questionservice.model.Question;
import org.aspectj.bridge.IMessage;
import org.aspectj.bridge.IMessageContext;

public class QuestionMapper {
    public  static Question toEntity(QuestionRequestDto questionRequestDto) {
        Question question = new Question();
        //question.setId(questionRequestDto.getId());
       //question.setId(questionRequestDto.getId());
        question.setQuestionText(questionRequestDto.getQuestionText());
        question.setExamId(questionRequestDto.getExamId());
        question.setOption1(questionRequestDto.getOption1());
        question.setOption2(questionRequestDto.getOption2());
        question.setOption3(questionRequestDto.getOption3());
        question.setOption4(questionRequestDto.getOption4());
        question.setCorrectOption(questionRequestDto.getCorrectOption());
        return question;

    }
    public  static QuestionResponseDto toResponseDto(Question question,String message) {
        return new QuestionResponseDto(
                question.getId(),

                message
        );

    }
    public  static QuestionResponseDto toFullResponseDto(Question q , String message) {
        return new QuestionResponseDto(
                q.getId(),
                message,
                q.getExamId(),
                q.getQuestionText(),
                q.getOption1(),
                q.getOption2(),
                q.getOption3(),
                q.getOption4(),
                q.getCorrectOption()

        );
    }
}
