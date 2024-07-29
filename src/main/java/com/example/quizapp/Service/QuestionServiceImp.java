package com.example.quizapp.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizapp.Model.Question;
import com.example.quizapp.Repository.QuestionRepository;

@Service
public class QuestionServiceImp implements QuestionService {

    private static final Logger logger = LoggerFactory.getLogger(QuestionServiceImp.class);

    @Autowired
    public QuestionRepository questionRepository;

    @Override
    public List<Question> getAllQuestion() {
        logger.info("Fetching all the question form the repository");
        List<Question> questions = questionRepository.findAll();
        logger.info("Fetched {} questions", questions.size());

        return questions;

    }

}
