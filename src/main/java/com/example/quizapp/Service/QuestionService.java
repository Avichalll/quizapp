package com.example.quizapp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.quizapp.Model.Question;

@Service
public interface QuestionService {

    List<Question> getAllQuestion();

    List<Question> getByCateogry(String category);

}
