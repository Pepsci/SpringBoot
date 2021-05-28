package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired UserRepository userRepository;
	@Autowired RoleRepository roleRepository;
	
    @GetMapping("/ajout")
    public String Ajout(Model model){
    	
    	model.addAttribute("roles",roleRepository.findAll());
        return "user/form";
    }

    @PostMapping("/ajout")
    public String Ajout(@Validated User user, BindingResult bindingResult) {
    	
    	if(bindingResult.hasErrors()) {
    		return "user/form";
    	}
    	
    	//CRUD --- C
    	userRepository.save(user);
		return "home";
    }
    
    	//CRUD --- R
    @GetMapping("/list")
    public String ListUser(Model model) {
    	
//    	List<User> users = userRepository.findAll();
//    	model.addAttribute("users", users);
    	
    	model.addAttribute("users", userRepository.findAll());
		return "user/list";
		
    }
    	

}


















