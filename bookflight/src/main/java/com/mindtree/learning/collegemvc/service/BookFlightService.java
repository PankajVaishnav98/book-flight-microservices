package com.mindtree.learning.collegemvc.service;

import java.util.List;
import java.util.Map;

import com.mindtree.learning.collegemvc.VO.Flight;
import com.mindtree.learning.collegemvc.VO.FlightDto;
import com.mindtree.learning.collegemvc.VO.UserVo;

public interface BookFlightService {

	public UserVo bookFlight(int uId, int fId, String seatType) throws Exception ;
	public Map<String, Object> getAllUsers(int fId) ;
	public String cancelBooking(int bId) throws Exception;
	public List<Flight> searchFlights(String source, String destination);
	public List<UserVo> yourBookings(int uId) throws Exception;
}
