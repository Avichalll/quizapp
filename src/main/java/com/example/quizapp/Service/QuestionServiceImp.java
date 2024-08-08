package com.example.quizapp.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizapp.Model.Question;
import com.example.quizapp.Repository.QuestionRepository;

import lombok.Builder;

@Builder
@Service
public class QuestionServiceImp implements QuestionService {

    private static final Logger logger = LoggerFactory.getLogger(QuestionServiceImp.class);

    @Autowired
    public QuestionRepository questionRepository;

    public void addQuestion(Question question3) {

        questionRepository.save(question3);

    }

    @Override
    public List<Question> getAllQuestion() {
        logger.info("Fetching all the question form the repository");
        List<Question> questions = questionRepository.findAll();

        logger.info("Fetched {} questions", questions.size());

        return questions;

    }

    @Override
    public List<Question> getByCateogry(String category) {

        List<Question> questions = questionRepository.findByCategory(category);
        return questions;

    }

    @Override
    public List<Question> getByLimitCategory(String category, int limit) {

        List<Question> questions = questionRepository.findRandomQuestionsByCategory(category);
        return questions;

    }

    @Override
    public void UpdateQuestion(Integer id, Question updatedQuestion) {

        Optional<Question> optionalQuestion = questionRepository.findById(id);

        if (optionalQuestion.isPresent()) {
            Question question = optionalQuestion.get();
            question.setCategory(updatedQuestion.getCategory());
            question.setDifficultylevel(updatedQuestion.getDifficultylevel());
            question.setOption1(updatedQuestion.getOption1());
            questionRepository.save(question);

            logger.info("Updated question with ID {}", id);
        } else {
            logger.warn("Question with ID {} not found", id);
        }

    }

}
