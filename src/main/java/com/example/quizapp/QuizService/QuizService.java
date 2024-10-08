package com.example.quizapp.QuizService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.quizapp.Model.Response;
import com.example.quizapp.QuizDoa.Quiz;

@Service
public interface QuizService {

    // public Quiz mapQnstoQuiz(Question question);

    public List<Quiz> getAllQuiz();

    public List<Quiz> getByCategory(String category);

    public int getScore(List<Response> responses);

    // public List<Quiz> createQuiz(String category, String title, String numQ);
    // public int getScore(List<Response> responses);

}
