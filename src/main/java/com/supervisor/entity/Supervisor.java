package com.supervisor.entity;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@JsonIncludeProperties({"id","jurisdiction","lastName","firstName"})
public class Supervisor {
	
	private String id;
    private String phone;
    private String jurisdiction;
    private String identificationNumber;
    
    @NotNull(message="lastName is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "firstName should contain only letters")
    private String lastName;
    
	@NotNull(message="firstName is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "firstName should contain only letters")
    private String firstName;
    
}
