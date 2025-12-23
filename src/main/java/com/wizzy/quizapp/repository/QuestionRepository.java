package com.wizzy.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wizzy.quizapp.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
