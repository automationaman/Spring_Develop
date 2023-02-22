package com.LearningSpring.LearnSpring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LearningSpring.LearnSpring.controller.Library;
import com.LearningSpring.LearnSpring.repository.LibraryRepository;

@Service
public class LibraryService {

@Autowired
LibraryRepository repository;
	
public String buildId(String isbn, int aisle) {
	return isbn+aisle;
}

public boolean checkAlreadyExists(String id) {
	Optional<Library> lib=repository.findById(id);
	return lib.isPresent();
}
}
