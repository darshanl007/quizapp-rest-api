package com.wizzy.quizapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wizzy.quizapp.entity.Question;
import com.wizzy.quizapp.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepository;

	public Question addQuestion(Question question) {
		return questionRepository.save(question);
	}

}
