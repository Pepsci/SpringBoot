package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Article;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class articleController {

	@Autowired UserRepository userRepository;
	@Autowired ArticleRepository articleRepository;
	
	@GetMapping("/ajout-article")
	public String ajout(Model model) {
		
		model.addAttribute("users",userRepository.findAll());
		return "article/form";
	}
	
	@PostMapping("/ajout-article")
	public String ajoutArticle(@Validated Article article,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
    		return "article/form";
    	}
		
		articleRepository.save(article);
		return "home";
		}
}
