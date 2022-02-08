package com.tutorial.uno.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="blog")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(name="blog_name")
    private String blogName;
    
    @Column(name="description")
    private String description;
    
    @Column(name="created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
	
	
}
