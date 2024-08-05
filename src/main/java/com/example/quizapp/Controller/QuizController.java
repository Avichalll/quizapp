package com.example.quizapp.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.Model.Response;
import com.example.quizapp.QuizDoa.Quiz;
import com.example.quizapp.QuizService.QuizlServiceImp;
import com.example.quizapp.Repository.QuestionRepository;

@RestController
@RequestMapping("/Quiz")
public class QuizController {

    private static final Logger logger = LoggerFactory.getLogger(QuizController.class);

    @Autowired
    public QuizlServiceImp quizlServiceImp;
    public QuestionRepository questionRepository;
    public Response response;

    @GetMapping("/AllQuiz")
    public List<Quiz> getMethodName() {
        List<Quiz> quiz = quizlServiceImp.getAllQuiz();
        return quiz;
    }

    @GetMapping("{category}")
    public List<Quiz> getMethodName(@PathVariable String category) {
        List<Quiz> quiz = quizlServiceImp.getByCategory(category);
        return quiz;
    }

    @PostMapping("/Response")
    public int postMethodName(@RequestBody List<Response> responses) {
        try {
            logger.info("Received responses: {}", responses);
            int ans = quizlServiceImp.getScore(responses);
            return ans;
        } catch (Exception e) {
            logger.error("Error processing responses", e);
            throw e;
        }
    }

}
