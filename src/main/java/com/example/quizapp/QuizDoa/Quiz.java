package com.example.quizapp.QuizDoa;

import com.example.quizapp.Repository.QuestionRepository;

public class Quiz {

    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    public QuestionRepository questionRepository;

    public void SETQuiz() {
        this.id = questionRepository.getById();
    }

}
