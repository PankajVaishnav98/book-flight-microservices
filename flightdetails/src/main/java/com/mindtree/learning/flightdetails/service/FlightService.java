package com.mindtree.learning.flightdetails.service;

import com.mindtree.learning.flightdetails.model.Flight;

public interface FlightService {

	public Flight addFlight(Flight flight);
	public Flight getFlightDetails(int fId) throws Exception;
	public String deleteFlight(int fId) throws Exception;
	public Flight updateFlightSource(int fId, String newSource) throws Exception;
	public Flight updateFlightDestination(int fId, String newDestination) throws Exception;
	public Flight updateFlightName(int fId, String newName) throws Exception;
	
}
