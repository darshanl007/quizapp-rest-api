package com.wizzy.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wizzy.quizapp.entity.Question;
import com.wizzy.quizapp.service.QuestionService;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

	@Autowired
	QuestionService questionService;

	// Add Question
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Question addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
	}

	// Get All Questions
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Question> getQuestions() {
		return questionService.getAllQuestions();
	}
}
