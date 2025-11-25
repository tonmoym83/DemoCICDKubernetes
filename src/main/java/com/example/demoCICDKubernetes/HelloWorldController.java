package com.example.demoCICDKubernetes;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	// Mapping the root URL ("/") to this method
    @RequestMapping("/") 
    public String helloWorld() { 
        
        // Returning a simple "Hello World" response
        return "Hello World  CICD  Kubernetes"; 
    } 
}
