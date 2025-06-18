package com.exam.examservice.controller;

import com.exam.examservice.dtos.ExamRequestDto;
import com.exam.examservice.dtos.ExamResponseDto;
import com.exam.examservice.model.Exam;
import com.exam.examservice.service.ExamService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
public class ExamController {
    private final ExamService examService;
    public ExamController(ExamService examService) {
        this.examService = examService;
    }
    @PostMapping("/create")
    public ResponseEntity<ExamResponseDto> createExam(@Valid @RequestBody ExamRequestDto examRequestDto) {
    ExamResponseDto examResponseDto=examService.createExam(examRequestDto);
    return new ResponseEntity<>(examResponseDto, HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<Page<ExamResponseDto>> getAllExam(@RequestParam (defaultValue = "1")int page,
                                                            @RequestParam(defaultValue = "2")int size,
                                                            @RequestParam(defaultValue = "id") String sortBy) {
        return ResponseEntity.ok(examService.getAllExams(page, size, sortBy));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ExamResponseDto> getExamById(@PathVariable Long id) {

        return ResponseEntity.ok(examService.getExamById(id));

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ExamResponseDto> updateExam(@Valid @PathVariable Long id , @RequestBody ExamRequestDto examRequestDto) {
        return ResponseEntity.ok(examService.updateExam(id,examRequestDto));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteExam(@PathVariable Long id) {
       return ResponseEntity.ok( examService.deleteExam(id));


    }

}
