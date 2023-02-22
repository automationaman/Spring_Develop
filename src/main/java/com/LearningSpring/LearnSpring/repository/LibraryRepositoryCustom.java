package com.LearningSpring.LearnSpring.repository;

import java.util.List;

import com.LearningSpring.LearnSpring.controller.Library;

public interface LibraryRepositoryCustom {

	public List<Library> findByAuthor(String authorname);
}
