package br.com.vitorlengovski.animalia.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@RequestMapping(path = "/clients", method = { RequestMethod.POST, RequestMethod.PUT })
	public ModelAndView save(Client client) {
		repository.save(client);
		   return new ModelAndView("redirect:/clients");
	}

	@GetMapping("/clients/{id}")
	public ModelAndView listById(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("clients");
		mv.addObject("client", repository.getReferenceById(id));
		mv.addObject("clients", repository.findAll());
		return mv;
	}

	@GetMapping("/clients/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		repository.deleteById(id);
		return new ModelAndView("redirect:/clients");
	}
}
