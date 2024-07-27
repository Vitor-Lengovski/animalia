package br.com.vitorlengovski.animalia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.vitorlengovski.animalia.controller.dto.OrderDTO;
import br.com.vitorlengovski.animalia.model.Client;
import br.com.vitorlengovski.animalia.model.Order;
import br.com.vitorlengovski.animalia.repository.ClientRepository;
import br.com.vitorlengovski.animalia.repository.OrderRepository;
import br.com.vitorlengovski.animalia.repository.PetRepository;

@RestController
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PetRepository petRepository;
	@Autowired
	
	private ClientRepository clientRepository;

	@GetMapping("/gerirServico")
	public ModelAndView getData() {
		ModelAndView mv = new ModelAndView("addOrders");
		return mv;
	}

	@GetMapping(path = "/gerirServico/{id}")
	public ModelAndView listById(@PathVariable Long id) {
		Order order = orderRepository.getReferenceById(id);
		ModelAndView mv = new ModelAndView("addOrders");
		
		mv.addObject("order", OrderDTO.converter(order));
		mv.addObject("clients", clientRepository.findAll());
		mv.addObject("pets", petRepository.findAll());
		return mv;
	}

	@PostMapping(path = "/gerirServico")
	public ModelAndView getClient(String cpf) {
		ModelAndView mv = new ModelAndView("addOrders");
		Client client = clientRepository.findByCpf(cpf);
		mv.addObject("client", client);
		mv.addObject("pets", petRepository.findByClientId(client.getId()));
		return mv;
		
	}
	
	@GetMapping("/servicos")
	public List<Order> listAll() {
		ModelAndView mv = new ModelAndView("manageOrders");
		mv.addObject("orders", orderRepository.findAll());
		return orderRepository.findAll();

	}
	
	@RequestMapping(path = "/servicos", method = { RequestMethod.POST, RequestMethod.PUT })
	public ModelAndView saveOrder(Order order) {
		orderRepository.save(order);
		return new ModelAndView("redirect:/servicos");
	}

	@GetMapping("/servicos/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		orderRepository.deleteById(id);
		return new ModelAndView("redirect:/servicos");
	}

}
