package com.example.quizapp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.quizapp.Model.Question;

@Service
public interface QuestionService {

    void addQuestion(Question question3);

    List<Question> getAllQuestion();

    List<Question> getByCateogry(String category);

    List<Question> getByLimitCategory(String category, int limit);

    public void UpdateQuestion(Integer id, Question updatedQuestion);

}
