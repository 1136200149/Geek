package com.geek.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Nav {

	@Id
	private String id;
	private String name;
	
	
	//一个栏目可以对应很多篇文章
	@OneToMany(mappedBy = "nav",cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<question> list;
	
	public Nav() {
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<question> getList() {
		return list;
	}
	public void setList(List<question> list) {
		this.list = list;
	}
	
	
	
}
