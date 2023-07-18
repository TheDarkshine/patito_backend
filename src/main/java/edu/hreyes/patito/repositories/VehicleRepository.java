package edu.hreyes.patito.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.hreyes.patito.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,String>{
	
	List<Vehicle> findAll();
	Optional<Vehicle> findById(String id);

}
