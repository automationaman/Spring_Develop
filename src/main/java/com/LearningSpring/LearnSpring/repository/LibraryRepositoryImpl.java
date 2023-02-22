package com.LearningSpring.LearnSpring.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import com.LearningSpring.LearnSpring.controller.Library;

public class LibraryRepositoryImpl implements LibraryRepositoryCustom{

	
	@Autowired
	@Lazy
	LibraryRepository repository;
	
	@Override
	public List<Library> findByAuthor(String authorname) {
		// TODO Auto-generated method stub
	List<Library> allBooks=	repository.findAll();
	List<Library> allBooksByAuthor = new ArrayList<Library>();
	
	for(Library item: allBooks) {
		if(item.getAuthor().equalsIgnoreCase(authorname)) {
			allBooksByAuthor.add(item);
		}
	}
		return allBooksByAuthor;
	}

}
