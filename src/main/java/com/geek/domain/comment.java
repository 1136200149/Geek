package com.geek.domain;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class comment {

	@Id
	private String id;
	private String name;
	private String userid;
	private Integer like;
	private Timestamp ctime;
	
	
	
	
}
