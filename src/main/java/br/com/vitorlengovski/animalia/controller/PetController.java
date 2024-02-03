package br.com.vitorlengovski.animalia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.vitorlengovski.animalia.model.Pet;
import br.com.vitorlengovski.animalia.repository.PetRepository;



@RestController
@RequestMapping("/home")
public class PetController {

	@Autowired
	private PetRepository repository;
	
	@ResponseBody
	@GetMapping("/animais")
	public List<Pet> findAll() {
		return null;
	}
	
	@PostMapping("/adicionar")
	public void save(@RequestBody Pet pet) {
		repository.save(pet);
	}
	
	
}
