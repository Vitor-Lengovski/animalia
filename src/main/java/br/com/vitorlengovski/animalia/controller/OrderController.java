package br.com.vitorlengovski.animalia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

	@GetMapping("/servicos")
	public ModelAndView listAll() {
		ModelAndView mv = new ModelAndView("orders");
		mv.addObject("orders", orderRepository.findAll());
		mv.addObject("clients", clientRepository.findAll());
		mv.addObject("pets", petRepository.findAll());
		return mv;
	}
	@PostMapping("/findClient")
	public ModelAndView getClient(String cpf) {
		ModelAndView mv = new ModelAndView("orders");
		mv.addObject("client", clientRepository.findByCpf(cpf));
		return mv;
		
	}
	@RequestMapping(path = "/servicos", method = { RequestMethod.POST, RequestMethod.PUT })
	public void saveOrder(Order order) {
		orderRepository.save(order);
	}

	@DeleteMapping("/servicos/{id}")
	public void delete(@PathVariable("id") Long id) {
		orderRepository.deleteById(id);
	}

}
