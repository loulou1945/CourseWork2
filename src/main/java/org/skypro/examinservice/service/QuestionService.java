package org.skypro.examinservice.service;

import org.skypro.examinservice.domain.Question;

import java.util.Collection;

public interface QuestionService {
    Question addQuestion(String question, String answer);

    Question removeQuestion(String question, String answer);

    Collection<Question> getAllQuestions();

    Question getRandomQuestion();
}
