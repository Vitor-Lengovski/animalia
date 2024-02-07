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
	private PetRepository petRepository;

	PetController(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT }, path = "/pets")
	public void save(@RequestBody Pet pet) {
		petRepository.save(pet);
	}

	@ResponseBody
	@GetMapping("/pets")
	public List<Pet> listAll() {
		return petRepository.findAll();
	}

	@ResponseBody
	@GetMapping(path = "/pets/{id}")
	public Optional<Pet> listById(@PathVariable Long id) {
		return petRepository.findById(id);
	}

	@DeleteMapping(path = "/excluir/{id}")
	public void delete(@PathVariable Long id) {
		petRepository.deleteById(id);
	}

}
