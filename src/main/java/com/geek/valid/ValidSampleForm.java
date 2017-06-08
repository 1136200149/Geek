package com.geek.valid;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class ValidSampleForm {

    @NotBlank  
    @Size(max=5)  
    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
    
    
    
    
}
