package com.supervisor.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class NotificationRequest {
	
	@NotNull(message="firstName is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "firstName should contain only letters")
	private String firstName;
	
	
	@NotNull(message="lastName is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "lastName should contain only letters")
	private String lastName;
	
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email format")
    private String email;
	
	@Pattern(regexp = "^\\+?[0-9-]+$", message = "Invalid phone number format")
    private String phoneNumber;
	
	@Valid
	@NotNull(message="supervisor is required")
    private Supervisor supervisor;
    
}
