package com.wizzy.quizapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	public List<Question> getAllQuestions() {
		return questionRepository.findAll();
	}

	public ResponseEntity<Question> getQuestionById(int id) {
		Optional<Question> question = questionRepository.findById(id);

		if (question.isPresent()) {
			return ResponseEntity.ok(question.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
