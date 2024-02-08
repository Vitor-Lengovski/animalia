package br.com.vitorlengovski.animalia.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.vitorlengovski.animalia.model.Client;

public class ClientDTO {

	private Long id;
	private String name;
	private String cpf;
	private String phoneNumber;
	private String email;
	
	public static List<ClientDTO> converter(List<Client> clients) {
        return clients.stream().map(ClientDTO::new).collect(Collectors.toList());
    }

	public ClientDTO(Client client) {
		super();
		this.id = client.getId();
		this.name = client.getName();
		this.cpf = client.getCpf();
		this.phoneNumber = client.getPhoneNumber();
		this.email = client.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
