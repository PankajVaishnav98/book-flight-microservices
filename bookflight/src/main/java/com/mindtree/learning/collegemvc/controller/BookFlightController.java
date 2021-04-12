package com.mindtree.learning.collegemvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.learning.collegemvc.exception.ControllerException.ControllerException;
import com.mindtree.learning.collegemvc.exception.ServiceException.ServiceException;
import com.mindtree.learning.collegemvc.service.BookFlightService;
import com.mindtree.learning.collegemvc.service.impl.BookFlightImpl;

@RestController
@RequestMapping("/booking")
@RefreshScope
public class BookFlightController {

	@Autowired
	private BookFlightService fs = new BookFlightImpl();

	@Value("${my.greeting}")
	private String msg;
	
	@RequestMapping("/property")
	public String getProperty() {
		return msg;
	}
	
	@RequestMapping("/searchFlight/{source}/{destination}")
	public ResponseEntity<?> searchFlights(@PathVariable("source") String source,
			@PathVariable("destination") String destination) throws ControllerException {
		try {
			return ResponseEntity.ok().body(fs.searchFlights(source, destination));
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	@RequestMapping("/getall/{fId}")
	public ResponseEntity<?> getAllUsers(@PathVariable int fId) throws ControllerException {
		try {
			return ResponseEntity.ok().body(fs.getAllUsers(fId));
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	@RequestMapping("/book-flight/{uId}/{fId}/{seatType}")
	public ResponseEntity<?> bookFlight(@PathVariable("uId") int uId, @PathVariable("fId") int fId,
			@PathVariable("seatType") String seatType) throws ControllerException {
		try {
			return ResponseEntity.ok().body(fs.bookFlight(uId, fId, seatType));
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	@RequestMapping("/yourBookings/{uId}")
	public ResponseEntity<?> yourBookings(@PathVariable("uId") int uId) throws ControllerException {
		try {
			return ResponseEntity.ok().body(fs.yourBookings(uId));
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	@RequestMapping("/cancel-booking/{bId}")
	public ResponseEntity<?> cancelBooking(@PathVariable("bId") int bId) throws ControllerException {
		try {
			return ResponseEntity.ok().body(fs.cancelBooking(bId));
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}

}
