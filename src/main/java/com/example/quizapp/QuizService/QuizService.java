package com.example.quizapp.QuizService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.quizapp.QuizDoa.Quiz;

@Service
public interface QuizService {

    // public Quiz mapQnstoQuiz(Question question);

    public List<Quiz> getAllQuiz();

}
