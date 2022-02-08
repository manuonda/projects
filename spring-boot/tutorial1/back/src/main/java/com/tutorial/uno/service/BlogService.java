package com.tutorial.uno.service;

import java.util.List;

import com.tutorial.uno.model.Blog;

public interface BlogService {
  
	public Blog add(Blog blog);
	
	public List<Blog> getAll();
	
	public Blog update(Blog blog);
	
	public void delete(Long id);
	
	public Blog getBlogById(Long id);
}
