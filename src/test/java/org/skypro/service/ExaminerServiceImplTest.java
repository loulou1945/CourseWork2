package org.skypro.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.examinservice.service.ExaminerServiceImpl;
import org.skypro.examinservice.service.JavaQuestionService;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @InjectMocks
    ExaminerServiceImpl examinerService;

    @Mock
    private JavaQuestionService javaQuestionService;

    @Test
    void WhenQuestionsIsNotEnough_thenReturnThrowException() {
        when(javaQuestionService.getAllQuestions()).thenReturn(Collections.emptyList());

        assertThrows(ResponseStatusException.class,
                () -> examinerService.getQuestions(1)
        );
    }
}
