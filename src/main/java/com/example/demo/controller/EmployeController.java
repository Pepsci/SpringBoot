package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Employe;
import com.example.demo.repository.EmployeRepository;

@Controller
public class EmployeController<plublic> {

	@Autowired EmployeRepository employeRepository;
	
	@GetMapping("/ajoutEmploye")
	public String AjoutEmploye() {
		return "employe/formEmploye";
	}
	
	@PostMapping("ajoutEmploye")
	public String AjoutEmploye(@Validated Employe employe, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
    		return "employe/formEmploye";
    	}
		
		employeRepository.save(employe);
		return "home";
	}
	

	@GetMapping("/listemploye")
	public String ListEmp(Model model) {
		
		model.addAttribute("employes", employeRepository.findAll());
		return "employe/listEmploye";
	}
	
	@GetMapping("/show/{id}")
	public String show(@PathVariable(value = "id") Long employeId,Model model){
		
// option 1		
//		Optional<Employe> employe = employeRepository.findById(employeId);
//		
//		if (employe.isPresent()) {
//			model.addAttribute("employe" , employe.get());
//		}
 //option 2		
		model.addAttribute("employe",employeRepository.findById(employeId).get());
		System.out.println(employeRepository.findById(employeId).toString());
		return "employe/show";
	}

//option 1
	@PostMapping("/show/{id}")
	public String updateEmploye(@Validated Employe employe,BindingResult bindingResult) {
	if(bindingResult.hasErrors()) {
		return "employe/listemploye";
	}
	System.out.println(employe.getId());
	employeRepository.save(employe);
	return "redirect:/listemploye";
	}
	
// option 2	
//	@PostMapping("/show/{id}")
//	public String update(@PathVariable(value = "id") Long employeId,Model model, 
//			@Validated Employe employeDetail, BindingResult bindingResult)throws AttributeNotFoundException {
//		
//		if(bindingResult.hasErrors()) {
//    		return "employe/formEmploye";
//    	}
//				
//			Employe employe = employeRepository.findById(employeId).orElseThrow(() -> new AttributeNotFoundException("Invalid user Id:" + employeId));
//			
//			employe.setNom(employeDetail.getNom());
//			employe.setPrenom(employeDetail.getPrenom());
//			employe.setMail(employeDetail.getMail());
//			employe.setFonction(employeDetail.getFonction());
//			
//			employeRepository.save(employe);
//			return "redirect:/listemploye";
//	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Employe employe = employeRepository.findById(id)
	    .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		employeRepository.delete(employe);
	    return "redirect:/listemploye";
	}

	
	
	
		
}	
	










