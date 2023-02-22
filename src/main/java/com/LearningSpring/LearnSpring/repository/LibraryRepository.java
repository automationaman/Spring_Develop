package com.LearningSpring.LearnSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LearningSpring.LearnSpring.controller.Library;

public interface LibraryRepository extends JpaRepository<Library, String>,LibraryRepositoryCustom {

}
