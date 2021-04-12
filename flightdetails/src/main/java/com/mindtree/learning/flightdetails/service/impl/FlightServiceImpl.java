package com.mindtree.learning.flightdetails.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mindtree.learning.flightdetails.exception.ServiceException.ServiceException;
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
	public String deleteFlight(int fId) throws ServiceException {
		String toReturn = null;
		try {
		Flight flight = fr.findById(fId).orElseThrow(()-> new ServiceException("No Such Flight Id Exist"));
		toReturn = "Fight : " + flight.getName() + " deleted Successfully";
		fr.delete(flight);
		}catch(DataAccessException e) {
			throw new ServiceException(e.getMessage());
		}
		return toReturn;
	}

	@Override
	public Flight updateFlightSource(int fId, String newSource) throws ServiceException {
		Flight flight = null;
		try {
		flight = fr.findById(fId).orElseThrow(()-> new ServiceException("No Such Flight Id Exist"));
		flight.setSource(newSource);
		flight = fr.save(flight);
		}catch(DataAccessException e) {
			throw new ServiceException(e.getMessage());
		}
		return flight;
	}

	@Override
	public Flight updateFlightDestination(int fId, String newDestination) throws ServiceException {
		Flight flight = null;
		try {
		flight = fr.findById(fId).orElseThrow(()-> new ServiceException("No Such Flight Id Exist"));
		flight.setDestination(newDestination);
		flight = fr.save(flight);
		}catch(DataAccessException e) {
			throw new ServiceException(e.getMessage());
		}
		return flight;
	}

	@Override
	public Flight updateFlightName(int fId, String newName) throws ServiceException {
		Flight flight = null;
		try {
		flight = fr.findById(fId).orElseThrow(()-> new ServiceException("No Such Flight Id Exist"));
		flight.setName(newName);
		flight = fr.save(flight);
		}catch(DataAccessException e) {
		throw new ServiceException(e.getMessage());
	}
		return flight;
	}

	@Override
	public Flight getFlightDetails(int fId) throws ServiceException {
		try {
		return fr.findById(fId).orElseThrow(()-> new ServiceException("No Such Flight Id Exist"));
		}catch(DataAccessException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<Flight> getAllFlights() throws ServiceException{
		try {
		return fr.findAll();}
		catch(DataAccessException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<Flight> searchFlights(String source, String destination) throws ServiceException {
		try {
		return fr.searchFlights(source, destination);
		}catch(DataAccessException e) {
			throw new ServiceException(e.getMessage());
		}
	}
		

}
