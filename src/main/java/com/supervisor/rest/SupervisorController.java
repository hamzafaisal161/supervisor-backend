package com.supervisor.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supervisor.entity.NotificationRequest;
import com.supervisor.entity.Supervisor;
import com.supervisor.service.SupervisorService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api")
@RestController
public class SupervisorController {

	private SupervisorService supervisorService;
	
	public SupervisorController(SupervisorService supervisorService) {
		this.supervisorService = supervisorService;
	}
	
	@GetMapping("supervisors")
	public ResponseEntity<List<Supervisor>> getAllSupervisors(){
		return new ResponseEntity<>(supervisorService.getAllSupervisors(),HttpStatus.OK);
	}
	
	@PostMapping("submit")
	public ResponseEntity<String> submitNotification(@Valid @RequestBody NotificationRequest notificationRequest, BindingResult result) {
		if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation error: " + result.getAllErrors().get(0).getDefaultMessage());
        }
        System.out.println(notificationRequest);
        return ResponseEntity.noContent().build();
	}
}
