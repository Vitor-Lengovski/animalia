package br.com.vitorlengovski.animalia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.vitorlengovski.animalia.controller.dto.PetDTO;
import br.com.vitorlengovski.animalia.model.Pet;
import br.com.vitorlengovski.animalia.repository.PetRepository;

@RestController
public class PetController {

	@Autowired
	private PetRepository repository;

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT }, path = "/pets")
	public void save(@RequestBody Pet pet) {
		repository.save(pet);
	}

	@GetMapping("/pets")
	public ModelAndView listAll() {
		List<Pet> pets = repository.findAll();
		ModelAndView mv = new ModelAndView("pets");
		mv.addObject("pets", PetDTO.converter(pets));
		return mv;
	}

	@GetMapping(path = "/pets/{id}")
	public ModelAndView listById(@PathVariable Long id) {
		Pet pet = repository.getReferenceById(id);
		ModelAndView mv = new ModelAndView("pets");
		
		mv.addObject("pet", PetDTO.converter(pet));
		mv.addObject("pets", repository.findAll());
		return mv;
	}

	@GetMapping(path = "/pets/excluir/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
