package edu.hreyes.patito.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.hreyes.patito.entities.Order;


public interface OrderRepository extends JpaRepository<Order,String>{
	
	List<Order> findAll();

}
