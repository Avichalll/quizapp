package com.example.quizapp.QuizService;

import org.springframework.stereotype.Service;

import com.example.quizapp.Model.Question;
import com.example.quizapp.QuizDoa.Quiz;

@Service
public class Quizmapper {

    public static Quiz mapQnstoQuiz(Question question) {

        Quiz q = new Quiz();
        q.setId(question.getId());
        q.setQuestionTitle(question.getQuestionTitle());
        q.setOption1(question.getOption1());
        q.setOption2(question.getOption2());
        q.setOption3(question.getOption3());
        q.setOption4(question.getOption4());
        return q;

    }
}
