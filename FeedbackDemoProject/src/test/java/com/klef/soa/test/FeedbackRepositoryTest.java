package com.klef.soa.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase.Replace;

import com.klef.soa.entity.Feedback;
import com.klef.soa.repository.FeedbackRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FeedbackRepositoryTest {
	@Autowired
	private FeedbackRepo repo;
	
	@Test
	void testFindAllUsers() {
		List<Feedback> user=repo.findAll();
		assertNotNull(user);
		assertFalse(user.isEmpty());
		System.out.println("total user:"+user.size());
	}
	@Test
	void testFindByName() {
		List<Feedback> user=repo.findByName("Yeswanth");
		assertNotNull(user);
		
		assertEquals("Yeswanth", user.get(0).getName());
		System.out.println("Name :"+user.get(0).getName());
		
	}
	@Test
	void testFindById() {
		Optional<Feedback> user=repo.findById(1L);
		assertTrue(user.isPresent());
		assertEquals(1L, user.get().getId());
		System.out.println("Name :"+user.get().getName());
		System.out.println("status :"+user.get().getStatus());
	}
	@Test
	void testDatabaseConnection() {
		long count=repo.count();
		assertTrue(count>=0);
		System.out.println("Total feedbacks in the database:"+count);
	}
	@Test
	void testFindByType() {
		List<Feedback> user=repo.findByType("Education");
		assertEquals("Education", user.get(1).getType());
		System.out.println("type:"+user.get(1).getType());
	}
}
