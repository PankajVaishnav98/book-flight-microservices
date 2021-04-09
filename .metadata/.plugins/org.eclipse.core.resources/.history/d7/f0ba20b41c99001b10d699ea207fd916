package com.mindtree.learning.collegemvc.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mindtree.learning.collegemvc.VO.Flight;

@FeignClient(url = "http://localhost:8989/app/flights/flight", name = "FLIGHT-CLIENT")
public interface FlightClient {

	@GetMapping("/getdetails/{fId}")
	Flight getFlight(@PathVariable("fId") int fId);

}
