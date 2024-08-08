package com.example.quizapp.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.quizapp.Model.Question;
import com.example.quizapp.Repository.QuestionRepository;

public class QuestionServiceImpTest {
    @InjectMocks
    QuestionServiceImp questionServiceImp;

    @Mock
    QuestionRepository questionRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUpdateQuestion() {
        Question question = new Question();

        question.setId(21);
        question.setQuestionTitle("this is my first question");
        question.setOption1("Option 1");
        question.setOption2("Option 2");
        question.setOption3("Option 3");
        question.setOption4("Option 4");
        question.setCategory("medium");
        question.setRightAnswer("Option 1");
        question.setCategory("java");
        questionServiceImp.addQuestion(question);
        Question question2 = new Question();
        question2.setId(22);
        question2.setQuestionTitle("this is my first question");
        question2.setOption1("Option 1");
        question2.setOption2("Option 2");
        question2.setOption3("Option 3");
        question2.setOption4("Option 4");
        question2.setCategory("medium");
        question2.setRightAnswer("Option 1");
        question2.setCategory("java");
        questionServiceImp.addQuestion(question2);

        Optional<Question> question3 = questionRepository.findById(21);
        question3.ifPresent(q -> q.setCategory("c++"));

        // questionServiceImp.addQuestion(question3);
        ;

    }

    @Test
    void testAddQuestion() {
        Question question = new Question();
        question.setId(21);
        question.setQuestionTitle("this is my first question");
        question.setOption1("Option 1");
        question.setOption2("Option 2");
        question.setOption3("Option 3");
        question.setOption4("Option 4");
        question.setCategory("medium");
        question.setRightAnswer("Option 1");
        question.setCategory("java");

        Question question2 = new Question();
        question2.setId(22);
        question2.setQuestionTitle("this is my first question");
        question2.setOption1("Option 1");
        question2.setOption2("Option 2");
        question2.setOption3("Option 3");
        question2.setOption4("Option 4");
        question2.setCategory("medium");
        question2.setRightAnswer("Option 1");
        question2.setCategory("java");
        questionServiceImp.addQuestion(question);
        questionServiceImp.addQuestion(question2);

        Mockito.when(questionRepository.findById(question.getId())).thenReturn(Optional.empty());

        Mockito.when(questionRepository.save(question)).thenReturn(question);
        verify(questionRepository, times(1)).save(question);

    }

    @Test
    void testGetAllQuestion() {
        Question question = new Question();
        question.setId(21);
        question.setQuestionTitle("this is my first question");
        question.setOption1("Option 1");
        question.setOption2("Option 2");
        question.setOption3("Option 3");
        question.setOption4("Option 4");
        question.setCategory("java");
        question.setRightAnswer("Option 1");
        question.setCategory("java");
        question.setDifficultylevel("medium");

        when(questionRepository.findAll()).thenReturn(List.of(question));
        when(questionServiceImp.getAllQuestion()).thenReturn(List.of(question));
        assertEquals(question, questionRepository.findAll().get(0));
    }

    @Test
    void testGetByCateogry() {
        Question question = new Question();
        question.setId(21);
        question.setQuestionTitle("this is my first question");
        question.setOption1("Option 1");
        question.setOption2("Option 2");
        question.setOption3("Option 3");
        question.setOption4("Option 4");
        question.setRightAnswer("Option 1");
        question.setDifficultylevel("Medium");
        question.setCategory("java");
        when(questionRepository.save(question)).thenReturn(question);
        // second object
        Question question2 = new Question();
        question2.setId(22);
        question2.setQuestionTitle("this is my first question");
        question2.setOption1("Option 1");
        question2.setOption2("Option 2");
        question2.setOption3("Option 3");
        question2.setOption4("Option 4");
        question2.setCategory("Easy");
        question2.setDifficultylevel("Easy");
        question2.setRightAnswer("Option 1");
        question2.setCategory("python");
        Question question3 = new Question();
        question3.setId(23);
        question3.setQuestionTitle("this is my third question");
        question3.setOption1("Option X");
        question3.setOption2("Option Y");
        question3.setOption3("Option Z");
        question3.setOption4("Option W");
        question3.setRightAnswer("Option X");
        question3.setDifficultylevel("Hard");
        question3.setCategory("python");

        List<Question> expectedQuestions = Arrays.asList(question, question2, question3);
        when(questionRepository.findByCategory("java")).thenReturn(expectedQuestions);

        // Act
        List<Question> actualQuestions = questionServiceImp.getByCateogry("java");

        // Assert
        assertEquals(expectedQuestions, actualQuestions);

    }

    @Test
    void testGetByLimitCategory() {

    }
}
