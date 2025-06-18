package com.exam.questionservice.serviceImpl;

import com.exam.questionservice.config.RestTemplateConfig;
import com.exam.questionservice.dtos.QuestionRequestDto;
import com.exam.questionservice.dtos.QuestionResponseDto;
import com.exam.questionservice.mapper.QuestionMapper;
import com.exam.questionservice.model.Question;
import com.exam.questionservice.repository.QuestionRepository;
import com.exam.questionservice.service.QuestionService;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {
    private  final QuestionRepository questionRepository;
    private RestTemplate restTemplate;
    public QuestionServiceImpl(QuestionRepository questionRepository, RestTemplateConfig restTemplateConfig) {
        this.questionRepository = questionRepository;
        this.restTemplate = new RestTemplate();
    }


    @Override
    public QuestionResponseDto addQuestion(QuestionRequestDto questionRequestDto) {
        String url = "http://localhost:8080/exams/" + questionRequestDto.getExamId();  //  Correct endpoint

        try {
            restTemplate.getForObject(url, Object.class);  // You just need to check if it exists
        } catch (HttpClientErrorException.NotFound ex) {
            throw new RuntimeException("Invalid Exam Id: " + questionRequestDto.getExamId());
        }
        //map dto to Entity
        Question question = QuestionMapper.toEntity(questionRequestDto);
        //save question in DB
        Question saved=questionRepository.save(question);
        return QuestionMapper.toResponseDto(saved,"Question added");

    }

    @Override
    public QuestionResponseDto getQuestionById(Long id) {
        Question question=questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found with id: " + id));
        return QuestionMapper.toResponseDto(question,"Question found");
    }


   /* @Override
    public List<QuestionResponseDto> getAllQuestions() {
        List<Question>questions=questionRepository.findAll();
        return  questions.stream().map(q-> QuestionMapper.toFullResponseDto(q,"fatched sucessfully")).collect(Collectors.toList());
    }

    */

    @Override
    public List<Question> getQuestionByExamId(Long examId) {
        return questionRepository.findByExamId(examId);
    }

    @Override
    public QuestionResponseDto updateQuestion(Long id, QuestionRequestDto questionRequestDto) {
        Question question=questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found with id: " + id));
        String url = "http://localhost:8080/exams/" + questionRequestDto.getExamId();
        try {
            restTemplate.getForObject(url, Object.class);
        }
        catch (HttpClientErrorException.NotFound ex) {
            throw new RuntimeException("Invalid Exam Id: " + questionRequestDto.getExamId());
        }
        question.setExamId(questionRequestDto.getExamId());
        question .setQuestionText(questionRequestDto.getQuestionText());
        question.setOption1(questionRequestDto.getOption1());
        question.setOption2(questionRequestDto.getOption2());
        question.setOption3(questionRequestDto.getOption3());
        question.setOption4(questionRequestDto.getOption4());
        question.setCorrectOption(questionRequestDto.getCorrectOption());
        Question updated=questionRepository.save(question);
        return QuestionMapper.toResponseDto(updated,"Question updated");

    }


    @Override
    public QuestionResponseDto deleteQuestion(Long id) {
         Question question=questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found with id: " + id));
         questionRepository.delete(question);
         return QuestionMapper.toResponseDto(question,"Question deleted");
    }

    @Override
    public Page<QuestionResponseDto> getALLQuestions(int size, int page, String SortBy) {
        Pageable pageable= PageRequest.of(page,size, Sort.by(SortBy));
        Page<Question> questions=questionRepository.findAll(pageable);
        return questions.map(q-> QuestionMapper.toResponseDto(q,"Question fetched"));
    }



}
