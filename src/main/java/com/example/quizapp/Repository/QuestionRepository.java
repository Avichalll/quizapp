package com.example.quizapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizapp.Model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
