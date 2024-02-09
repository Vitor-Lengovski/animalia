package br.com.vitorlengovski.animalia.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.vitorlengovski.animalia.model.Client;
import br.com.vitorlengovski.animalia.repository.ClientRepository;

@RestController
@CrossOrigin("*")
public class ClientController {

	@Autowired
	private ClientRepository repository;

	@GetMapping(path = "/clients")
	public ModelAndView listAll() {
		ModelAndView mv = new ModelAndView("clients");
		mv.addObject("clients", repository.findAll());
		return mv;
	}
	
	@GetMapping("/clients/{id}")
	@ResponseBody
	public Optional<Client> listById(@PathVariable("id") Long id) {
		return repository.findById(id);
	}

	@RequestMapping(path = "/clients", method = { RequestMethod.POST, RequestMethod.PUT })
	public ModelAndView save(Client client) {
		repository.save(client);
		   return new ModelAndView("redirect:/clients");
	}
	
	@DeleteMapping("/clients/{id}")
	public void delete(@PathVariable("id") Long id) {
		repository.deleteById(id);
	}
}
