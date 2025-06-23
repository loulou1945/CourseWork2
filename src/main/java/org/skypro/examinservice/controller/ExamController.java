package org.skypro.examinservice.controller;

import org.skypro.examinservice.domain.Question;
import org.skypro.examinservice.service.ExaminerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.skypro.examinservice.exception.NotEnoughQuestionException;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public ResponseEntity<?> getQuestions(@PathVariable int amount) {
        try {
            return ResponseEntity.ok(examinerService.getQuestions(amount));
        } catch (NotEnoughQuestionException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
