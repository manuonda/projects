package com.tutorial.uno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.uno.model.Blog;
import com.tutorial.uno.service.BlogService;

@RestController
//@RequestMapping("api")
@CrossOrigin(origins = "*")
public class BlogController {

	@Autowired
	private BlogService blogService;

	@PostMapping("/api/create")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Blog> add(@RequestBody Blog blog) {
		Blog blogEntity = blogService.add(blog);
		return ResponseEntity.ok().body(blogEntity);
	}

	@PutMapping("/api/update/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Blog> update(@PathVariable("id") Long id, @RequestBody Blog blog) {
        Blog blogUpdate = this.blogService.update(blog);
		return ResponseEntity.ok().body(blogUpdate);
	}

	@GetMapping("/api/blog/{id}")
	public ResponseEntity<Blog> getById(@PathVariable("id") Long id) {
		Blog blog = this.blogService.getBlogById(id);
		return ResponseEntity.ok().body(blog);
	}

	@GetMapping("/api/all")
	public ResponseEntity<?> getAll() {
		List<Blog> listado = this.blogService.getAll();
		return ResponseEntity.ok().body(listado);
	}

}
