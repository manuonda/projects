package com.tutorial.uno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tutorial.uno.model.Blog;
import com.tutorial.uno.repository.BlogRepository;

public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository repository;
	
	@Override
	public Blog add(Blog blog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blog> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blog update(Blog blog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Blog getBlogById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
