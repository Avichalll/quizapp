package com.example.quizapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.quizapp.Model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    // @Query(value = "SELECT * FROM question q Where q.category=:category",
    // nativeQuery = true)
    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question WHERE category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(@Param("category") String category, @Param("numQ") int numQ);

    // @Query(value = "select * from question where question.category=:category
    // order by ", nativeQuery = true)

    // List<Question> findRandomQuestionsByCategory(String category, int numQ);

    // @Query(value = "SELECT * FROM question WHERE category = :category ORDER BY
    // RAND() LIMIT :limit", nativeQuery = true)
    // List<Question> findRandomQuestionsByCategory(@Param("category") String
    // category, @Param("limit") int limit);
}
