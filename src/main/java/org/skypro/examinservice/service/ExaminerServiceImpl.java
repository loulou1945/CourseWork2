package org.skypro.examinservice.service;

import org.skypro.examinservice.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final Random random = new Random();
    private final QuestionService questionService;

    public ExaminerServiceImpl (QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if(amount > questionService.getAllQuestions().size()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "More questions requested than available");
        }
        Set<Question> uniqueQuestions = new HashSet<>();
        while (uniqueQuestions.size() < amount) {
            uniqueQuestions.add(questionService.getRandomQuestion());
        }
        return new ArrayList<>(uniqueQuestions);
    }
}
