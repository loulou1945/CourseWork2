package org.skypro.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.examinservice.domain.Question;
import org.skypro.examinservice.service.JavaQuestionService;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @InjectMocks
    private JavaQuestionService service;

    @Test
    void addAndRemoveQuestionTest() {
        Question question = service.addQuestion("Q1", "A1");
        assertTrue(service.getAllQuestions().contains(question));
        assertEquals(question, service.removeQuestion("Q1", "A1"));
        assertFalse(service.getAllQuestions().contains(question));
    }

    @Test
    void whenAddQuestionWhichAlreadyFound_thenReturnQuestionFoundException() {
        Question question = service.addQuestion("Q1", "A1");
        assertTrue(service.getAllQuestions().contains(question));
        assertEquals(question, service.addQuestion("Q1", "A1"));
    }
}
