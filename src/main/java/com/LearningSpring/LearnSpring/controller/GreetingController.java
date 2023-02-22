package com.LearningSpring.LearnSpring.controller;


import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

@Autowired	
Greeting greeting;	

AtomicLong counter = new AtomicLong();

@GetMapping("/greeting")	
public Greeting greeting(@RequestParam(value="name")String name) {
	
	greeting.setContent("My name is "+name+" mishra");
	greeting.setId(counter.incrementAndGet());
	return greeting;
	
}

}
