package com.LearningSpring.LearnSpring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.LearningSpring.LearnSpring.controller.Library;
import com.LearningSpring.LearnSpring.repository.LibraryRepository;

@SpringBootApplication
public class LearnSpringApplication {//implements CommandLineRunner{
	
	@Autowired
	LibraryRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringApplication.class, args);
	}


/*	@Override
	public void run(String[] args) {
	Library lib =	repository.findById("fdsefr343").get();
	System.out.println(lib.getAuthor());
	
	Library entity = new Library();
	entity.setAisle(45);
	entity.setAuthor("Amrita");
	entity.setBook_name("API_learn");
	entity.setId("ID_343");
	entity.setIsbn("ISIN");
//	repository.save(entity);
	List<Library> allrecords= repository.findAll();
	
	for(Library item : allrecords) {
		System.out.println(item.getBook_name());
	}
	
	repository.delete(entity);
	}
	*/
} 
