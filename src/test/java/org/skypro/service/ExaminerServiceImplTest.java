package org.skypro.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.examinservice.domain.Question;
import org.skypro.examinservice.service.ExaminerServiceImpl;
import org.skypro.examinservice.service.JavaQuestionService;
import org.skypro.examinservice.service.QuestionService;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Mock
    private JavaQuestionService javaQuestionService;

    @Test
    void whenQuestionsIsNotEnough_thenReturnThrowException() {
        when(javaQuestionService.getAllQuestions()).thenReturn(Collections.emptyList());

        assertThrows(ResponseStatusException.class,
                () -> examinerService.getQuestions(1)
        );
    }

    @Test
    void whenQuestionIsEnough_thenReturnQuestions() {
        List<Question> mockQuestions = new ArrayList<>();
        mockQuestions.add(new Question("Q1", "A1"));
        mockQuestions.add(new Question("Q2", "A2"));
        mockQuestions.add(new Question("Q3", "A3"));
        mockQuestions.add(new Question("Q4", "A4"));
        mockQuestions.add(new Question("Q5", "A5"));

        when(javaQuestionService.getAllQuestions()).thenReturn(mockQuestions);
        when(javaQuestionService.getRandomQuestion())
                .thenReturn(mockQuestions.get(0))
                .thenReturn(mockQuestions.get(2))
                .thenReturn(mockQuestions.get(4));

        Collection<Question> exam = examinerService.getQuestions(3);

        verify(javaQuestionService, times(1)).getAllQuestions();
        verify(javaQuestionService, times(3)).getRandomQuestion();

        assertEquals(3, exam.size());

        assertTrue(exam.contains(mockQuestions.get(0)));
        assertTrue(exam.contains(mockQuestions.get(2)));
        assertTrue(exam.contains(mockQuestions.get(4)));

        assertFalse(exam.contains(mockQuestions.get(1)));
        assertFalse(exam.contains(mockQuestions.get(3)));
    }
}
