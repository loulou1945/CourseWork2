package org.skypro.service;

import org.junit.jupiter.api.Test;
import org.skypro.examinservice.domain.Question;
import org.skypro.examinservice.service.JavaQuestionService;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {
    private JavaQuestionService service = new JavaQuestionService();

    @Test
    void addAndRemoveQuestionTest() {
        Question question = service.addQuestion("Q1", "A1");
        assertTrue(service.getAllQuestions().contains(question));
        assertEquals(question, service.removeQuestion("Q1", "A1"));
        assertFalse(service.getAllQuestions().contains(question));
    }
}
