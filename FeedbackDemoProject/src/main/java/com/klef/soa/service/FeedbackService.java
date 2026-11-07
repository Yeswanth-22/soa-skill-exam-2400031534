package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Feedback;

public interface FeedbackService {
	Feedback addFeedback(Feedback f);
	Feedback updateFeedback(Long id,Feedback F);
	List<Feedback> displayAllFeedback();
	Feedback displaybyId(Long id);
	String deletebyId(Long id);
	List<Feedback> findByName(String name);
	List<Feedback> findByType(String type);
}
