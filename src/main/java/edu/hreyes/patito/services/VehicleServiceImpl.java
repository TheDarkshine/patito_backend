package edu.hreyes.patito.services;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hreyes.patito.entities.Vehicle;
import edu.hreyes.patito.repositories.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService{
	
	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}

	@Override
	@Transactional
	public Vehicle saveVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Vehicle> findVehicleById(String id) {
		return vehicleRepository.findById(id);
	}

	@Override
	@Transactional
	public Vehicle save(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

}
