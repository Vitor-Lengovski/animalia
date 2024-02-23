package br.com.vitorlengovski.animalia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.vitorlengovski.animalia.controller.dto.PetDTO;
import br.com.vitorlengovski.animalia.model.Pet;
import br.com.vitorlengovski.animalia.repository.ClientRepository;
import br.com.vitorlengovski.animalia.repository.PetRepository;

@RestController
public class PetController {

	@Autowired
	private PetRepository petRepository;
	@Autowired
	private ClientRepository clientRepository;

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT }, path = "/pets")
	public ModelAndView save(Pet pet) {
		petRepository.save(pet);
		return new ModelAndView("redirect:/pets");
	}

	@GetMapping("/pets")
	public ModelAndView listAll() {
		List<Pet> pets = petRepository.findAll();
		ModelAndView mv = new ModelAndView("pets");
		mv.addObject("pets", PetDTO.converter(pets));
		mv.addObject("clients", clientRepository.findAll());
		return mv;
	}

	@GetMapping(path = "/pets/{id}")
	public ModelAndView listById(@PathVariable Long id) {
		Pet pet = petRepository.getReferenceById(id);
		ModelAndView mv = new ModelAndView("pets");
		
		mv.addObject("pet", PetDTO.converter(pet));
		mv.addObject("clients", clientRepository.findAll());
		mv.addObject("pets", petRepository.findAll());
		return mv;
	}

	@GetMapping(path = "/pets/excluir/{id}")
	public ModelAndView delete(@PathVariable Long id) {
		petRepository.deleteById(id);
		return new ModelAndView("redirect:/pets");

	}

}
