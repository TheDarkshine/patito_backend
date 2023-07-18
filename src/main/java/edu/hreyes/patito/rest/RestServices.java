package edu.hreyes.patito.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.hreyes.patito.entities.Order;
import edu.hreyes.patito.entities.Vehicle;
import edu.hreyes.patito.services.OrderService;
import edu.hreyes.patito.services.VehicleService;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class RestServices {
	
	Logger log = LoggerFactory.getLogger(RestServices.class);
	
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private OrderService orderService;
	
	@GetMapping("vehicles")
	ResponseEntity<Object> listVehicles(){
		log.info("Get Vehicles");
		return ResponseEntity.ok().body(vehicleService.findAll());
	}
	
	@GetMapping("vehicles/{id}")
	ResponseEntity<Object> vehicleDetail(@PathVariable String id){
		log.info("Get Vehicles Detail");
		Optional<Vehicle> vehicle = vehicleService.findVehicleById(id);
		if(vehicle.isEmpty()){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(vehicle.get());
	}
	
	@PutMapping("vehicles")
	ResponseEntity<Object> updateVehicle(@RequestBody Vehicle vehicle){
		log.info("Update Vehicle");
		
		Optional<Vehicle> vehicleOptional = vehicleService.findVehicleById(vehicle.getId());
		if(vehicleOptional.isEmpty()){
			return ResponseEntity.notFound().build();
		}
		
		Vehicle vehicleDb = vehicleOptional.get();
		vehicleDb.setAvailable(vehicle.getAvailable());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.save(vehicleDb));
	}
	
	@PostMapping("vehicles")
	public ResponseEntity<Object> createVehicle(@RequestBody Vehicle vehicle){
		Vehicle vehicleSaved = vehicleService.saveVehicle(vehicle);
		return ResponseEntity.status(HttpStatus.CREATED).body(vehicleSaved);
	}
	
	@GetMapping("orders")
	ResponseEntity<Object> listOrders(){
		log.info("Get Orders");
		return ResponseEntity.ok().body(orderService.findAll());
	}
	
	@PostMapping("orders")
	public ResponseEntity<Object> createVehicle(@RequestBody Order order){
		Order orderSaved = orderService.saveOrder(order);
		return ResponseEntity.status(HttpStatus.CREATED).body(orderSaved);
	}

}
