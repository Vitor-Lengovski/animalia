package br.com.vitorlengovski.animalia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	private final ClientRepository repository;

	ClientController(ClientRepository repository) {
		this.repository = repository;
	}

	@ResponseBody
	@GetMapping("/clients")
	public List<Client> listAll(){
		return repository.findAll();
	}
	@RequestMapping(path = "/clients", method = { RequestMethod.POST, RequestMethod.PUT })
	public void save(@RequestBody Client client) {
		repository.save(client);
	}
}
