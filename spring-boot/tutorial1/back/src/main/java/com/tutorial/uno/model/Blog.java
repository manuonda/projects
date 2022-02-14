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

import com.fasterxml.jackson.annotation.JsonProperty;

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
	@JsonProperty("id")
	private Long id;
	
    @Column(name="blog_name")
    @JsonProperty("blogName")
    private String blogName;
    
    @Column(name="description")
    @JsonProperty("description")
    private String description;
    
    @Column(name="created_date")
    @JsonProperty("createdDate")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
	
}
