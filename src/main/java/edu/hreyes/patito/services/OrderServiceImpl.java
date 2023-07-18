package edu.hreyes.patito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.hreyes.patito.entities.Order;
import edu.hreyes.patito.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

}
