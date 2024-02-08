package br.com.vitorlengovski.animalia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.vitorlengovski.animalia.controller.dto.PetDTO;
import br.com.vitorlengovski.animalia.model.Pet;
import br.com.vitorlengovski.animalia.repository.PetRepository;

@RestController
public class PetController {

	@Autowired
	private PetRepository petRepository;

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT }, path = "/pets")
	public void save(@RequestBody Pet pet) {
		petRepository.save(pet);
	}

	@GetMapping("/pets")
	public List<PetDTO> listAll() {
		List<Pet> pets = petRepository.findAll();
		return PetDTO.converter(pets);
	}

	@GetMapping(path = "/pets/{id}")
	public PetDTO listById(@PathVariable Long id) {
		Pet pet = petRepository.getReferenceById(id);
		return PetDTO.converter(pet);	
	}

	@DeleteMapping(path = "/pets/{id}")
	public void delete(@PathVariable Long id) {
		petRepository.deleteById(id);
	}

}
