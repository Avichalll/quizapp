package com.example.quizapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.QuizDoa.Quiz;
import com.example.quizapp.QuizService.QuizlServiceImp;

@RestController
@RequestMapping("/Quiz")
public class QuizController {

    @Autowired
    public QuizlServiceImp quizlServiceImp;

    @GetMapping("/AllQuiz")
    public List<Quiz> getMethodName() {

        List<Quiz> quiz = quizlServiceImp.getAllQuiz();
        return quiz;

    }

}
