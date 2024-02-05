package br.com.vitorlengovski.animalia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.vitorlengovski.animalia.model.Pet;
import br.com.vitorlengovski.animalia.repository.PetRepository;

@RestController
public class PetController {

	@Autowired
	private final PetRepository repository;

	PetController(PetRepository repository) {
		this.repository = repository;
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT }, path = "/animais")
	public void save(@RequestBody Pet pet) {
		repository.save(pet);
	}

	@ResponseBody
	@GetMapping("/animais")
	public List<Pet> listAll() {
		return repository.findAll();
	}

	@ResponseBody
	@GetMapping(path = "/animais/{id}")
	public Optional<Pet> listById(@PathVariable Long id) {
		return repository.findById(id);
	}

	@DeleteMapping(path = "delete/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
