package br.com.vitorlengovski.animalia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;
	private Long raceId;
	private double weight;
	private String type;
	private char sex;

	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;

	public Pet() {

	}

	public Pet(String name, Client client, Long raceId, double weight, String type, char sex) {
		this.name = name;
		this.client = client;
		this.raceId = raceId;
		this.weight = weight;
		this.type = type;
		this.sex = sex;
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

	public Client getClientId() {
		return client;
	}

	public void setClientId(Client client) {
		this.client = client;
	}

	public Long getRaceId() {
		return raceId;
	}

	public void setRaceId(Long raceId) {
		this.raceId = raceId;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

}
