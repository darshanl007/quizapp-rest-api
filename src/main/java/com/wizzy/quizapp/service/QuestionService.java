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

	public ResponseEntity<Question> updateQuestion(int id, Question updatedQuestion) {
		Optional<Question> existing = questionRepository.findById(id);
		if (existing.isPresent()) {
			Question q = existing.get();
			q.setQuestion(updatedQuestion.getQuestion());
			q.setOption1(updatedQuestion.getOption1());
			q.setOption2(updatedQuestion.getOption2());
			q.setOption3(updatedQuestion.getOption3());
			q.setOption4(updatedQuestion.getOption4());
			q.setCorrectAnswer(updatedQuestion.getCorrectAnswer());

			Question updated = questionRepository.save(q);
			return ResponseEntity.ok(updated);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
