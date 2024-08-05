package com.example.quizapp.QuizService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.quizapp.Model.Question;
import com.example.quizapp.QuizDoa.Quiz;

// @ExtendWith(MockitoExtension.class)
public class QuizmapperTest {

    Quizmapper quizmapper;

    @BeforeEach
    public void setUp() {
        quizmapper = new Quizmapper();
    }

    @Test
    public void shouldQnsmaptoQuiz() {

        Question question = new Question();
        question.setId(21);
        question.setQuestionTitle("this is my first question");
        question.setOption1("Option 1");
        question.setOption2("Option 2");
        question.setOption3("Option 3");
        question.setOption4("Option 4");

        Quiz quiz = quizmapper.mapQnstoQuiz(question);

        assertEquals(question.getId(), quiz.getId());
        Assertions.assertEquals(question.getQuestionTitle(), quiz.getQuestionTitle());

        assertEquals(question.getOption1(), quiz.getOption1());
        assertEquals(question.getOption2(), quiz.getOption2());
        assertEquals(question.getOption3(), quiz.getOption3());
        assertEquals(question.getOption4(), quiz.getOption4());

    }

    @Test
    public void QnsnotpresnentthrownullPointer() {
        var exp = assertThrows(NullPointerException.class, () -> quizmapper.mapQnstoQuiz(null));
        assertEquals("Question is not Present", exp.getMessage());

    }
}