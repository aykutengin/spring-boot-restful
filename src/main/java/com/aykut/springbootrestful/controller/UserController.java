package com.aykut.springbootrestful.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aykut.springbootrestful.model.User;
import com.aykut.springbootrestful.repository.IUserRepository;

@RestController
public class UserController {

	@Autowired
	private final IUserRepository repository;

	UserController(IUserRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/users/{name}")
	@ExceptionHandler
	List<User> UsersByName(HttpServletResponse response, @PathVariable String name) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		return repository.findByName(name);
	}

}
