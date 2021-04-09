package com.mindtree.learning.collegemvc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mindtree.learning.collegemvc.repository.*;
import com.mindtree.learning.collegemvc.VO.UserVo;
import com.mindtree.learning.collegemvc.client.FlightClient;
import com.mindtree.learning.collegemvc.client.UserClient;
import com.mindtree.learning.collegemvc.model.BookFlight;
import com.mindtree.learning.collegemvc.VO.Flight;
import com.mindtree.learning.collegemvc.VO.User;
import com.mindtree.learning.collegemvc.service.BookFlightService;

@Service
public class BookFlightImpl implements BookFlightService {

	@Autowired
	private BookFlightRepo fr;

	@Autowired
	private UserClient userClient;

	@Autowired
	private FlightClient flightClient;

	/*
	 * @Autowired private RestTemplate resttemplate;
	 */

	@Override
	public UserVo bookFlight(int uId, int fId) {
		UserVo vo = new UserVo();
		// Flight flight =
		// resttemplate.getForObject("http://ZUULSERVICE/app/flights/flight/getdetails/"
		// + fId,Flight.class);
		// User user =
		// resttemplate.getForObject("http://ZUULSERVICE/app/users/user/get/" + uId,
		// User.class);
		Flight flight = flightClient.getFlight(fId);
		User user = userClient.getUsers(uId);
		vo.setUser(user);
		vo.setFlight(flight);
		BookFlight booking = new BookFlight();
		booking.setfId(fId);
		booking.setuId(uId);
		booking = fr.save(booking);
		vo.setBookingId(booking.getbId());
		return vo;
	}

	@Override
	public Map<String, Object> getAllUsers(int fId) {
		// Flight flight =
		// resttemplate.getForObject("http://ZUULSERVICE/app/flights/flight/getdetails/"
		// + fId,Flight.class);
		Flight flight = flightClient.getFlight(fId);
		Map<String, Object> flightdata = new HashMap<>();
		flightdata.put("flight", flight);
		List<Integer> uIds = fr.getUids(fId);
		List<User> users = uIds.stream().map(uId -> {
			// User u = resttemplate.getForObject("http://ZUULSERVICE/app/users/user/get/" +
			// uId, User.class);
			User u = userClient.getUsers(uId);

			return u;
		}).collect(Collectors.toList());

		flightdata.put("passangers", users);

		return flightdata;
	}

	@Override
	public String cancelBooking(int bId) throws Exception {
		BookFlight booking = fr.findById(bId).orElseThrow(() -> new Exception("NO Such booking Id is there"));
		fr.delete(booking);
		return "Booking canceld Successfully";
	}

}
