package com.exam.examservice.service_impl;

import com.exam.examservice.dtos.ExamRequestDto;
import com.exam.examservice.dtos.ExamResponseDto;
import com.exam.examservice.mapper.ExamMapper;
import com.exam.examservice.model.Exam;
import com.exam.examservice.repository.ExamRepository;
import com.exam.examservice.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;
    @Autowired
    public ExamServiceImpl(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }



    @Override
    public ExamResponseDto createExam(ExamRequestDto examRequestDto) {
      Exam exam = ExamMapper.toExam(examRequestDto);
      Exam saved=examRepository.save(exam);
      return ExamMapper.toExamResponseDto(saved,"Exam created");

    }

    @Override
    public List<ExamResponseDto> getAllExams() {
        List<Exam> exams=examRepository.findAll();
        return  exams.stream().map(exam -> ExamMapper.toExamResponseDto(exam,"Exam fatched")).collect(Collectors.toList());


    }

    @Override
    public ExamResponseDto getExamById(Long id) {
        Exam exam=examRepository.findById(id).orElseThrow(()->new RuntimeException("No exam found with id: "+ id));

        return  ExamMapper.toExamResponseDto(exam,"Exam found");
    }

    @Override
    public ExamResponseDto updateExam(Long id, ExamRequestDto examRequestDto) {
        Exam exam= examRepository.findById(id).orElseThrow(()-> new RuntimeException("No exam found with id: "+id )); // DECLARE IT HERE


          exam.setTitle(exam.getTitle());
            exam.setDescription(exam.getDescription());
            exam.setDuration(exam.getDuration());
            exam.setExamDate(exam.getExamDate());

            Exam updated= examRepository.save(exam);
            return ExamMapper.toExamResponseDto(updated,"Exam updated");

    }

    @Override
    public String deleteExam(Long id) {
        Exam exam=examRepository.findById(id).orElseThrow(()->new RuntimeException("No exam found with id: "+ id));
    examRepository.delete(exam);
    return "Exam deleted";
    }

    @Override
    public Page<ExamResponseDto> getAllExams(int size, int page, String sortBy) {
        Pageable pageable= PageRequest.of(page,size, Sort.by(sortBy));
        Page<Exam> exams=examRepository.findAll(pageable);
        return exams.map(exam -> ExamMapper.toExamResponseDto(exam,"Exam fetched"));
    }


}



