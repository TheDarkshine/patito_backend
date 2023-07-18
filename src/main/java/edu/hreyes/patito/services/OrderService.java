package edu.hreyes.patito.services;

import java.util.List;
import edu.hreyes.patito.entities.Order;

public interface OrderService {
	
	List<Order> findAll();
	Order saveOrder(Order order);

}
