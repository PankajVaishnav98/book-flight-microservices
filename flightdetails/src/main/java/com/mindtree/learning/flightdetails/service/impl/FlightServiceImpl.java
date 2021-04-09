package com.mindtree.learning.flightdetails.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.learning.flightdetails.model.Flight;
import com.mindtree.learning.flightdetails.repository.FlightRepo;
import com.mindtree.learning.flightdetails.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService{

	@Autowired
	private FlightRepo fr;
	
	@Override
	public Flight addFlight(Flight flight) {
		return fr.save(flight);
	}

	@Override
	public String deleteFlight(int fId) throws Exception {
		Flight flight = fr.findById(fId).orElseThrow(()-> new Exception("No Such Flight Id Exist"));
		String toReturn = "Fight : " + flight.getName() + " deleted Successfully";
		fr.delete(flight);
		return toReturn;
	}

	@Override
	public Flight updateFlightSource(int fId, String newSource) throws Exception {
		Flight flight = fr.findById(fId).orElseThrow(()-> new Exception("No Such Flight Id Exist"));
		flight.setSource(newSource);
		flight = fr.save(flight);
		return flight;
	}

	@Override
	public Flight updateFlightDestination(int fId, String newDestination) throws Exception {
		Flight flight = fr.findById(fId).orElseThrow(()-> new Exception("No Such Flight Id Exist"));
		flight.setDestination(newDestination);
		flight = fr.save(flight);
		return flight;
	}

	@Override
	public Flight updateFlightName(int fId, String newName) throws Exception {
		Flight flight = fr.findById(fId).orElseThrow(()-> new Exception("No Such Flight Id Exist"));
		flight.setName(newName);
		flight = fr.save(flight);
		return flight;
	}

	@Override
	public Flight getFlightDetails(int fId) throws Exception {

		return fr.findById(fId).orElseThrow(()-> new Exception("No Such Flight Id Exist"));
	}

	@Override
	public List<Flight> getAllFlights() {
		return fr.findAll();
	}

	@Override
	public List<Flight> searchFlights(String source, String destination) throws Exception {
		
		return fr.searchFlights(source, destination);
	}

}
