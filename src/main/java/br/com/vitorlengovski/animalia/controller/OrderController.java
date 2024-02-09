package br.com.vitorlengovski.animalia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(path = "/servicos", method = { RequestMethod.POST, RequestMethod.PUT })
	public void saveOrder(@RequestBody Order order) {
		repository.save(order);
	}

	@DeleteMapping("/servicos/{id}")
	public void delete(@PathVariable("id") Long id) {
		repository.deleteById(id);
	}

}
