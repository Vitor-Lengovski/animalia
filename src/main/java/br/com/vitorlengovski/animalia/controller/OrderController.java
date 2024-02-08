package br.com.vitorlengovski.animalia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.vitorlengovski.animalia.controller.dto.OrderDTO;
import br.com.vitorlengovski.animalia.model.Order;
import br.com.vitorlengovski.animalia.repository.OrderRepository;


@RestController
public class OrderController {

	@Autowired
	private OrderRepository repository;
	
	@GetMapping("/servicos")
	public List<OrderDTO> listOrders() {
		List<Order> orders = repository.findAll();
		return OrderDTO.converter(orders);
	}
	
	@PostMapping("/servicos")
	public void savoOrder(@RequestBody Order order) {
		repository.save(order);
	}
	
	
	
}
