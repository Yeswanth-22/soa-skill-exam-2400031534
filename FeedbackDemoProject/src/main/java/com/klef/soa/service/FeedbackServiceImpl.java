package com.klef.soa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Feedback;
import com.klef.soa.exception.ResourceNotFoundException;
import com.klef.soa.repository.FeedbackRepo;


@Service
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	private FeedbackRepo repo;
	@Override
	public Feedback addFeedback(Feedback f) {
		return repo.save(f);
	}

	@Override
	public Feedback updateFeedback(Long id,Feedback F) {
		Feedback ff=repo.findById(id).orElseThrow(
				()->new ResourceNotFoundException("not found with id:"+id));
		ff.setName(F.getName());
		ff.setLocation(F.getLocation());
		ff.setStatus(F.getStatus());
		ff.setType(F.getType());
		return repo.save(ff);
	}

	@Override
	public List<Feedback> displayAllFeedback() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Feedback displaybyId(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).
				orElseThrow(()->
				new ResourceNotFoundException("not found with id:"+id));
	}

	@Override
	public String deletebyId(Long id) {
		Feedback f=repo.findById(id).orElseThrow(
				()->new ResourceNotFoundException("not found with id:"+id));
		repo.deleteById(id);
		return "successfully deleted";
	}

	@Override
	public List<Feedback> findByName(String name) {
		// TODO Auto-generated method stub
		return repo.findByName(name);
	}

	@Override
	public List<Feedback> findByType(String type) {
		// TODO Auto-generated method stub
		return repo.findByType(type);
	}

}
