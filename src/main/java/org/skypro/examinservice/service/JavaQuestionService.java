package org.skypro.examinservice.service;

import org.skypro.examinservice.domain.Question;
import org.skypro.examinservice.exception.QuestionFoundException;
import org.skypro.examinservice.exception.QuestionNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {
    private final List<Question> questions = new ArrayList<>();
    private final Random random = new Random();

    @Override
    public Question addQuestion(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        if (questions.contains(newQuestion)) {
            throw new QuestionFoundException("There is already such a question" + question);
        }
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question removeQuestion(String question, String answer) {
        Question toRemove = new Question(question, answer);
        if (!questions.remove(toRemove)) {
            throw new QuestionNotFoundException("Question not found: " + question);
        }
        return toRemove;
    }

    @Override
    public Collection<Question> getAllQuestions() {
        return new ArrayList<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        return questions.get(random.nextInt(questions.size()));
    }
}
