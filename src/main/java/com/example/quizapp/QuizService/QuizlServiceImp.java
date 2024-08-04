package com.example.quizapp.QuizService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizapp.Model.Question;
import com.example.quizapp.Model.Response;
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

    @Override
    public int getScore(List<Response> responses) {
        if (responses == null || responses.isEmpty()) {
            throw new IllegalArgumentException("Responses list cannot be null or empty");
        }

        List<Question> questions = responses.stream()
                .map(response -> questionRepository.findById(response.getId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        if (questions.isEmpty()) {
            throw new IllegalArgumentException("No valid questions found for the given responses");
        }

        int score = 0;
        for (Question question : questions) {
            Response response = responses.stream()
                    .filter(r -> r.getId().equals(question.getId()))

                    .findFirst()
                    .orElse(null);

            if (response != null && response.getAnswerResponse() != null
                    && response.getAnswerResponse().equals(question.getRightAnswer())) {
                score++;
            }
        }

        return score;
    }

    // @Override
    // public int getScore(List<Response> responses) {
    // List<Question> questions = responses.stream()
    // .map(response -> questionRepository.findById(response.getId()))
    // .filter(Optional::isPresent)
    // .map(Optional::get)
    // .collect(Collectors.toList());

    // // Process the questions as needed
    // // For example, you might want to calculate the score based on the questions
    // and
    // // responses

    // int score = 0;
    // for (Question question : questions) {
    // // Assuming Response has a method getAnswer() and Question has a method
    // // getCorrectAnswer()
    // Response response = responses.stream()
    // .filter(r -> r.getId().equals(question.getId()))
    // .findFirst()
    // .orElse(null);

    // if (response != null &&
    // response.getAnswerResponse().equals(question.getRightAnswer())) {
    // score++;
    // }
    // }

    // return score; // Return the calculated score
    // }

    // "*******"

    // @Override
    // public List<Quiz> createQuiz(String category, String title, String numQ) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method 'createQuiz'");
    // }

}
