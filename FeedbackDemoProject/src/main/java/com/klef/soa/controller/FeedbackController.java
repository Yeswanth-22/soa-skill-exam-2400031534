package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Feedback;
import com.klef.soa.service.FeedbackService;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	@Autowired
	private FeedbackService Fservice;
	
	@GetMapping("/")
	public String test() {
		return "Service is running...!!";
	}
	@PostMapping("/save")
	public ResponseEntity<Feedback> saveFeedback(@RequestBody Feedback f) {
		return new ResponseEntity<>(Fservice.addFeedback(f),HttpStatus.CREATED);
		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Feedback> updateFeedback(@PathVariable Long id ,@RequestBody Feedback f) {
		return ResponseEntity.ok(Fservice.updateFeedback(id,f));
	}
	@GetMapping("/displayall")
	public ResponseEntity<List<Feedback>> displayAllFeedback() {
		return ResponseEntity.ok(Fservice.displayAllFeedback());
	}
	@GetMapping("/displaybyid/{id}")
	public ResponseEntity<Feedback> displayByid(@PathVariable Long id) {
		return ResponseEntity.ok(Fservice.displaybyId(id));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletebyid(@PathVariable Long id) {
		return ResponseEntity.ok(Fservice.deletebyId(id));
	}
	@GetMapping("/findbyname/{name}")
	public ResponseEntity<List<Feedback>> findByName(@PathVariable String name) {
		return ResponseEntity.ok(Fservice.findByName(name));
	}
	@GetMapping("/findbytype/{type}")
	public ResponseEntity<List<Feedback>> findByType(@PathVariable String type) {
		return ResponseEntity.ok(Fservice.findByType(type));
	}
}
