package com.exam.questionservice.controller;

import com.exam.questionservice.dtos.QuestionRequestDto;
import com.exam.questionservice.dtos.QuestionResponseDto;
import com.exam.questionservice.model.Question;
import com.exam.questionservice.service.QuestionService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/question")
public class QuestionController {
    private final QuestionService questionService;
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @PostMapping("/create")
    public ResponseEntity<QuestionResponseDto> CreateQuestion( @RequestBody QuestionRequestDto questionRequestDto) {
        QuestionResponseDto responseDto=questionService.addQuestion(questionRequestDto);
        return  new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<Page<QuestionResponseDto>> getAllQuestion(@RequestParam(defaultValue = "1")int page, @RequestParam(defaultValue = "10")int size,
                                                                    @RequestParam(defaultValue = "id")String sortBy)
    {
        return ResponseEntity.ok(questionService.getALLQuestions(page,size,sortBy));

    }
    @GetMapping("{id}")
    public ResponseEntity<QuestionResponseDto> getAllQuestionById(@PathVariable Long id) {
        return  ResponseEntity.ok(questionService.getQuestionById(id));
    }
    @GetMapping("/List/{examId}")
    public List<Question> getQuestionById(@PathVariable Long examId)
    {
        return questionService.getQuestionByExamId(examId);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<QuestionResponseDto> updateQuestion(@PathVariable Long id,@RequestBody QuestionRequestDto questionRequestDto) {
        QuestionResponseDto response = questionService.updateQuestion(id,questionRequestDto);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<QuestionResponseDto> deleteQuestionById(@PathVariable Long id) {
        return  ResponseEntity.ok(questionService.deleteQuestion(id));
    }
}
