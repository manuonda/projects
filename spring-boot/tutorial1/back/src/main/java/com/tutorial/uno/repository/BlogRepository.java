package com.tutorial.uno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.uno.model.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

}
