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

import br.com.vitorlengovski.animalia.model.Client;
import br.com.vitorlengovski.animalia.repository.ClientRepository;

@RestController
public class ClientController {

	@Autowired
	private ClientRepository repository;

	@GetMapping(path = "/clients")
	public List<Client> listAll() {
		return repository.findAll();
	}
	
	@GetMapping("/clients/{id}")
	@ResponseBody
	public Optional<Client> listById(@PathVariable("id") Long id) {
		return repository.findById(id);
	}

	@RequestMapping(path = "/clients", method = { RequestMethod.POST, RequestMethod.PUT })
	public void save(@RequestBody Client client) {
		repository.save(client);
	}
	
	@DeleteMapping("/clients/{id}")
	public void delete(@PathVariable("id") Long id) {
		repository.deleteById(id);
	}
}
