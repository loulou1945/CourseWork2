package org.skypro.examinservice.controller;

import org.skypro.examinservice.domain.Question;
import org.skypro.examinservice.service.JavaQuestionService;
import org.skypro.examinservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public ResponseEntity<String> addQuestion(
            @RequestParam("question") String question,
            @RequestParam("answer") String answer
    ) {
        questionService.addQuestion(question, answer);
        return new ResponseEntity<>("Question added", HttpStatus.OK);
    }

    @GetMapping("/remove")
    public ResponseEntity<String> removeQuestion(
            @RequestParam("question") String question,
            @RequestParam("answer") String answer
    ) {
        questionService.removeQuestion(question, answer);
        return new ResponseEntity<>("Question removed", HttpStatus.OK);
    }

    @GetMapping
    public Collection<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }
}
