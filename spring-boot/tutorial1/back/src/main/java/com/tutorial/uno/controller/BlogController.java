package com.tutorial.uno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.uno.model.Blog;
import com.tutorial.uno.service.BlogService;

@RestController("/api")
public class BlogController {

	@Autowired 
	private BlogService blogService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Blog> add(
			@RequestBody Blog blog){
		
		Blog blogEntity = blogService.add(blog);
		
		return ResponseEntity.ok().body(blog);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Blog> update(@PathVariable("id") Long id, 
			@RequestBody Blog blog){
		
		return ResponseEntity.ok().body(blog);
	}
}
