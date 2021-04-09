package com.mindtree.learning.collegemvc.controller;


import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.learning.collegemvc.VO.Flight;
import com.mindtree.learning.collegemvc.VO.UserVo;

import com.mindtree.learning.collegemvc.service.BookFlightService;
import com.mindtree.learning.collegemvc.service.impl.BookFlightImpl;

@RestController
@RequestMapping("/booking")
@RefreshScope
public class BookFlightController {

	@Autowired
	private BookFlightService fs = new BookFlightImpl();
	
	/*
	 * @Value("${my.greeting}") private String msg;
	 * 
	 * @RequestMapping("/property") public String getProperty() { return msg; }
	 */
	
	///searching flight according source & destination, get list flight scheduled
	
	@RequestMapping("/searchFlight/{source}/{destination}")
	public List<Flight> searchFlights(@PathVariable("source") String source, @PathVariable("destination") String destination) {
		return fs.searchFlights(source, destination);
	}
	
	@RequestMapping("/getall/{fId}")
	public Map<String, Object> getAllUsers(@PathVariable int fId){
		return fs.getAllUsers(fId);
	}
	
	@RequestMapping("/book-flight/{uId}/{fId}/{seatType}")
	public UserVo bookFlight(@PathVariable("uId") int uId, @PathVariable("fId") int fId,@PathVariable("seatType") String seatType) throws Exception {
		return fs.bookFlight(uId, fId, seatType);
	}
	
	@RequestMapping("/yourBookings/{uId}")
	public List<UserVo> yourBookings(@PathVariable("uId") int uId) throws Exception{
		return fs.yourBookings(uId);
	}
	
	@RequestMapping("/cancel-booking/{bId}")
	public String cancelBooking(@PathVariable("bId") int bId) throws Exception {
		return fs.cancelBooking(bId);
	}

	
}

