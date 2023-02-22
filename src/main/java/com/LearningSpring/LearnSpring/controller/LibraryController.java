package com.LearningSpring.LearnSpring.controller;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.LearningSpring.LearnSpring.repository.LibraryRepository;
import com.LearningSpring.LearnSpring.service.LibraryService;

@RestController
public class LibraryController {

	@Autowired
	LibraryRepository repository;
	
	@Autowired
	ReturnResponse res;
	
	@Autowired
	LibraryService service;
	
	private static final Logger logger = LoggerFactory.getLogger(LibraryController.class);
	
	@PostMapping("/addBook")
	public  ResponseEntity<ReturnResponse> addBookImplementations(@RequestBody Library lib) {
		
		String id = service.buildId(lib.getIsbn(),lib.getAisle());
		if(!service.checkAlreadyExists(id)) {
		lib.setId(id);
		repository.save(lib);
		res.setId(id);
		res.setMsg("The book is added successfully");
		HttpHeaders headers= new HttpHeaders();
		headers.add("unique", id);
		logger.info("Book is added");
		return new ResponseEntity<ReturnResponse>(res,headers,HttpStatus.CREATED);
		}
		else {
			res.setId(id);
			res.setMsg("The book is already present");
			logger.info("book is already present");
			return new ResponseEntity<ReturnResponse>(res,HttpStatus.ACCEPTED);
		}
	}
	
	@GetMapping("/getBbook/{id}")
	public Library getBookById(@PathVariable(name="id") String id) {
		
		try {
			Library lib= repository.findById(id).get();
			logger.info("getbook by id api is working");
			return lib;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/getBook/author")
	public List<Library> getBookByAuthor(@RequestParam (value="authorname") String authorname){
		
		
		return repository.findByAuthor(authorname);
		
	}
	
	@PutMapping("/updateBook/{id}")
	public ResponseEntity<Library> updateBook(@PathVariable(name="id") String id, @RequestBody Library lib) {
		
		Library existingBook=	repository.findById(id).get();
		existingBook.setAisle(lib.getAisle());
		existingBook.setAuthor(lib.getAuthor());
		existingBook.setBook_name(lib.getBook_name()); 
		repository.save(existingBook);
		return new ResponseEntity<Library>(existingBook,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletebook/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable(name="id") String id) {
		
		try {
			Library deleteLibrary = repository.findById(id).get();
			repository.delete(deleteLibrary);
			return new ResponseEntity<>("Book is deleted",HttpStatus.ACCEPTED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getAllBooks")
	public List<Library> getAllBooks(){
		List<Library> lib = repository.findAll();
		logger.info("get method is successfull");
		return lib;
	}
	
}
