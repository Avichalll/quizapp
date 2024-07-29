package com.example.quizapp.QuestionController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.Model.Question;
import com.example.quizapp.Service.QuestionServiceImp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@RestController
@NoArgsConstructor
@Getter
@Setter
@RequestMapping("/Question")
public class QnsController {

    @Autowired
    QuestionServiceImp questionServiceImp;

    @GetMapping("/AllQuestion")
    public List<Question> getMethodName() {
        return questionServiceImp.getAllQuestion();

    }
    

}
