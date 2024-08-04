package com.example.quizapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping("")
    public String postMethodName(@PathVariable String entity) {
        // TODO: process POST request

        return entity;
    }

    @GetMapping("{category}")
    public List<Question> getMethodName(@PathVariable String category) {
        List<Question> questions = questionServiceImp.getByCateogry(category);
        return questions;
    }

    // @GetMapping("/limit/{category}")
    // public List<Question> getMethodName2(@RequestParam(value = "category") String
    // category) {
    // List<Question> questions = questionServiceImp.getByLimitCategory(category);
    // return questions;
    // }

    @GetMapping("/limit/{category}")
    public List<Question> getLimitedQuestionsByCategory(@PathVariable String category,
            @RequestParam(value = "limit", defaultValue = "5") int limit) {
        return questionServiceImp.getByLimitCategory(category, limit);
    }

    @PutMapping("path/{id}")
    public ResponseEntity<String> putMethodName(@PathVariable Integer id, @RequestBody Question entity) {
        questionServiceImp.UpdateQuestion(id, entity);

        return new ResponseEntity<String>("succefuly upated", HttpStatus.OK);
    }
}
