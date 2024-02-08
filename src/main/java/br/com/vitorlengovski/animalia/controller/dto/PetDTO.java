package br.com.vitorlengovski.animalia.controller.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.vitorlengovski.animalia.model.Client;
import br.com.vitorlengovski.animalia.model.Pet;

public class PetDTO {

	private Long id;
	private String name;
	private String breed;
	private double weight;
	private char sex;
	private Date birthDate;
	private Client client;

	public static List<PetDTO> converter(List<Pet> pets) {
		return pets.stream().map(PetDTO::new).collect(Collectors.toList());
	}

	public static PetDTO converter(Pet pet) {
		return new PetDTO(pet);
	}

	public PetDTO(Pet pet) {
		this.id = pet.getId();
		this.name = pet.getName();
		this.breed = pet.getBreed();
		this.weight = pet.getWeight();
		this.sex = pet.getSex();
		this.birthDate = pet.getBirthDate();
		this.client = pet.getClient();
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

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
