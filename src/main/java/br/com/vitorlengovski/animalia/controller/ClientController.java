package br.com.vitorlengovski.animalia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(path = "/client", method = { RequestMethod.POST, RequestMethod.PUT })
	public void save(@RequestBody Client client) {
		repository.save(client);
	}
}
