package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Persona;
import com.example.demo.repo.IPersonaRepo;

@Controller
public class DemoController {
	
	@Autowired
	private IPersonaRepo repo;
	
	@GetMapping("/saludo")
	public String saludo(@RequestParam(name="nombre", required=false, defaultValue="Mundo") String nombre, Model modelo) {
		Persona p = new Persona();
		p.setIdPersona(2);
		p.setNombre("Camila");
		repo.save(p);
		modelo.addAttribute("nombre",nombre);
		return "saludo";
	}
	
	@GetMapping("/listar")
	public String lista(Model modelo) {
		modelo.addAttribute("personas", repo.findAll());
		return "saludo";
	}

}
