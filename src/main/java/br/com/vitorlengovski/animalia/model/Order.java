package br.com.vitorlengovski.animalia.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.vitorlengovski.animalia.model.enums.Service;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private double price;
	@Column(name = "date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	@Enumerated(EnumType.STRING)
	private Service service;
	private String observation;

	@ManyToOne
	@JoinColumn(name = "pet_id")
	@JsonBackReference
	private Pet pet;

	@ManyToOne
	@JoinColumn(name = "client_id")
	@JsonBackReference
	private Client client;

	public Order() {

	}

	public Order(double price, Date date, Service service, String observation, Pet pet, Client client) {
		super();
		this.price = price;
		this.date = date;
		this.service = service;
		this.observation = observation;
		this.pet = pet;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
