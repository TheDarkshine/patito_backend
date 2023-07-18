package edu.hreyes.patito.services;

import java.util.List;
import java.util.Optional;

import edu.hreyes.patito.entities.Vehicle;

public interface VehicleService {
	
	List<Vehicle> findAll();
	Vehicle saveVehicle(Vehicle vehicle); 
	Optional<Vehicle> findVehicleById(String id);
	Vehicle save(Vehicle vehicle);

}
