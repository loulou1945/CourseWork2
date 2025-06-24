package org.skypro.examinservice.service;

import org.skypro.examinservice.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
