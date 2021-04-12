package com.mindtree.learning.flightdetails.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.learning.flightdetails.exception.ControllerException.ControllerException;
import com.mindtree.learning.flightdetails.exception.ServiceException.ServiceException;
import com.mindtree.learning.flightdetails.model.Flight;
import com.mindtree.learning.flightdetails.service.FlightService;
import com.mindtree.learning.flightdetails.service.impl.FlightServiceImpl;

@RestController
@RequestMapping("/flight")
@RefreshScope
public class FlightController {

	@Autowired
	private FlightService fs = new FlightServiceImpl();
	

	@Value("${my.greeting}")
	private String msg;
	
	@RequestMapping("/property")
	public String getProperty() {
		return msg;
	}
	
	@RequestMapping("/getdetails/{fId}")
	public ResponseEntity<?> getFlightDetails(@PathVariable int fId) throws ControllerException {
		try {
		return ResponseEntity.ok().body(fs.getFlightDetails(fId));
		}catch(ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@RequestMapping("/getAllFlights")
	public ResponseEntity<?> getAllFlights() throws ControllerException {
		try {
		return ResponseEntity.ok().body(fs.getAllFlights());
		}catch(ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@RequestMapping("/searchFlights/{source}/{destination}")
	public ResponseEntity<?> searchFlights(@PathVariable("source") String source,@PathVariable("destination") String destination) throws ControllerException {
		try {
		return ResponseEntity.ok().body(fs.searchFlights(source,destination));
		}catch(ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@RequestMapping("/add")
	public ResponseEntity<?> addFlight(@RequestBody Flight flight) throws ControllerException {
		try {
		return ResponseEntity.ok().body(fs.addFlight(flight));
		}catch(ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@RequestMapping("/delete/{fId}")
	public ResponseEntity<?> deleteFlight(@PathVariable int fId) throws ControllerException {
		try {
		return ResponseEntity.ok().body(fs.deleteFlight(fId));
		}catch(ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@RequestMapping("/updateFlight")
	public ResponseEntity<?> updateFlight(@RequestBody Flight flight)throws ControllerException  {
		try {
		return ResponseEntity.ok().body(fs.addFlight(flight));
		}catch(ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@RequestMapping("/update-source/{fId}/{newSource}")
	public ResponseEntity<?> updateSource(@PathVariable int fId, @PathVariable String newSource)throws ControllerException {
		try {
		return ResponseEntity.ok().body(fs.updateFlightSource(fId, newSource));
		}catch(ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@RequestMapping("/update-destination/{fId}/{newDestination}")
	public ResponseEntity<?> updateDestination(@PathVariable int fId, @PathVariable String newDestination) throws ControllerException {
		try {
		return ResponseEntity.ok().body(fs.updateFlightDestination(fId, newDestination));
		}catch(ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@RequestMapping("/update-Name/{fId}/{newName}")
	public ResponseEntity<?> updateName(@PathVariable int fId, @PathVariable String newName) throws ControllerException {
		try {
		return ResponseEntity.ok().body(fs.updateFlightName(fId, newName));
		}catch(ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
}