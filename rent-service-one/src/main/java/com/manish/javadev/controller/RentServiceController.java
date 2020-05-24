package com.manish.javadev.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manish.javadev.model.BookingDetail;

@RestController
@RequestMapping(value = "/api")
public class RentServiceController {

	private Map<Integer, BookingDetail> bookingDetailMap;

	// Dummy Data for Vehicle id 100 and 101 for userId 100
	public RentServiceController() {
		bookingDetailMap = new HashMap<Integer, BookingDetail>();

		bookingDetailMap.put(new Integer(100), new BookingDetail(100, 100, 250, "BTM", "Agara"));
		bookingDetailMap.put(new Integer(101), new BookingDetail(101, 100, 250, "Silk Board", "Agara"));
	}

	@RequestMapping(value = "/rent/{userId}/{vehicleId}")
	BookingDetail getRentForVehicles(@PathVariable("userId") int userId, @PathVariable("vehicleId") int vehicleId) {
		return bookingDetailMap.get(new Integer(vehicleId));
	}

	@RequestMapping(value = "/ping")
	public String ping() {
		return "Configuration is working fine";
	}
}