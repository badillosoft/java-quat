package com.quat.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloApiController {

	@GetMapping("")
	public String helloGet(@RequestParam int edad) {
		return String.format("Tu edad es: %d", edad);
	}
	
	@PostMapping("")
	public String helloPost(@RequestParam int edad) {
		return String.format("Tu edad es: %d", edad);
	}
	
}
