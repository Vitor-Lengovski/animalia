package br.com.vitorlengovski.animalia.controller.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.vitorlengovski.animalia.model.Order;
import br.com.vitorlengovski.animalia.model.Pet;
import br.com.vitorlengovski.animalia.model.enums.Service;

public class OrderDTO {

	private Long id;
	private double price;
	private Date date;
	private Service service;
	private String observation;
	private Pet pet;

	public static List<OrderDTO> converter(List<Order> orders) {
		return orders.stream().map(OrderDTO::new).collect(Collectors.toList());
	}

	public static OrderDTO converter(Order order) {
		return new OrderDTO(order);
	}

	public OrderDTO(Order order) {
		this.id = order.getId();
		this.price = order.getPrice();
		this.date = order.getDate();
		this.service = order.getService();
		this.observation = order.getObservation();
		this.pet = order.getPet();
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

}
