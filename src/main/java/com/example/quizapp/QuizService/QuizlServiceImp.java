package com.example.quizapp.QuizService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizapp.Model.Question;
import com.example.quizapp.QuizDoa.Quiz;
import com.example.quizapp.Repository.QuestionRepository;

@Service
public class QuizlServiceImp implements QuizService {

    @Autowired
    public QuestionRepository questionRepository;

    @Autowired
    public Quizmapper quizmapper;

    public List<Quiz> getAllQuiz() {
        List<Question> questions = questionRepository.findAll();
        List<Quiz> quiz = questions.stream()
                .map(question -> Quizmapper.mapQnstoQuiz(question))
                .collect(Collectors.toList());
        return quiz;
    }

    @Override
    public List<Quiz> getByCategory(String category) {
        List<Question> questions = questionRepository.findByCategory(category);
        List<Quiz> quizzes = questions.stream()
                .map(question -> Quizmapper.mapQnstoQuiz(question))
                .collect(Collectors.toList());
        return quizzes;
    }

    // @Override
    // public List<Quiz> createQuiz(String category, String title, String numQ) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method 'createQuiz'");
    // }

}
