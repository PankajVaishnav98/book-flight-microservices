package com.mindtree.learning.flightdetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.learning.flightdetails.model.Flight;
import com.mindtree.learning.flightdetails.service.FlightService;
import com.mindtree.learning.flightdetails.service.impl.FlightServiceImpl;

@RestController
@RequestMapping("/flight")
public class FlightController {

	@Autowired
	private FlightService fs = new FlightServiceImpl();
	
	@RequestMapping("/getdetails/{fId}")
	public Flight getFlightDetails(@PathVariable int fId) throws Exception {
		return fs.getFlightDetails(fId);
	}
	
	@RequestMapping("/add")
	public Flight addFlight(@RequestBody Flight flight) {
		return fs.addFlight(flight);
	}
	
	@RequestMapping("/delete/{fId}")
	public String deleteFlight(@PathVariable int fId) throws Exception{
		return fs.deleteFlight(fId);
	}
	
	@RequestMapping("/update-source/{fId}/{newSource}")
	public Flight updateSource(@PathVariable int fId, @PathVariable String newSource) throws Exception{
		return fs.updateFlightSource(fId, newSource);
	}
	
	@RequestMapping("/update-destination/{fId}/{newDestination}")
	public Flight updateDestination(@PathVariable int fId, @PathVariable String newDestination) throws Exception{
		return fs.updateFlightDestination(fId, newDestination);
	}
	
	@RequestMapping("/update-Name/{fId}/{newName}")
	public Flight updateName(@PathVariable int fId, @PathVariable String newName) throws Exception{
		return fs.updateFlightName(fId, newName);
	}
}