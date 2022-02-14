package com.tutorial.uno.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.uno.model.Blog;
import com.tutorial.uno.repository.BlogRepository;


@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository repository;
	
	@Override
	public Blog add(Blog blog) {
		return repository.save(blog);
	}

	@Override
	public List<Blog> getAll() {
		return repository.findAll();
	}

	@Override
	public Blog update(Blog blog) {
		return repository.save(blog);
	}

	@Override
	public void delete(Long id) {
	   Optional<Blog> optional = repository.findById(id);
       repository.delete(optional.get());
	}

	@Override
	public Blog getBlogById(Long id) {
		Optional<Blog> optional =  repository.findById(id);
		return optional.get();
	}

}
