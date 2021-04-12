package com.mindtree.learning.collegemvc.service;

import java.util.List;
import java.util.Map;

import com.mindtree.learning.collegemvc.VO.Flight;
import com.mindtree.learning.collegemvc.VO.UserVo;
import com.mindtree.learning.collegemvc.exception.ServiceException.ServiceException;

public interface BookFlightService {

	public UserVo bookFlight(int uId, int fId, String seatType) throws ServiceException;
	public Map<String, Object> getAllUsers(int fId)  throws ServiceException;
	public String cancelBooking(int bId)  throws ServiceException;
	public List<Flight> searchFlights(String source, String destination)  throws ServiceException;
	public List<UserVo> yourBookings(int uId)  throws ServiceException;
}
