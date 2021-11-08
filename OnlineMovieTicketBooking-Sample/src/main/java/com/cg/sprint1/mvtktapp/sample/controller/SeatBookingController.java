package com.cg.sprint1.mvtktapp.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.sprint1.mvtktapp.sample.entity.SeatBooking;
import com.cg.sprint1.mvtktapp.sample.service.SeatBookingService;

@RestController
@RequestMapping("/seatBooking")
public class SeatBookingController
{
	@Autowired
	SeatBookingService seatBookingService;
	
	@GetMapping(value="/{bookingId}",produces="application/json")
	public ResponseEntity<SeatBooking> getMovieDetails(@PathVariable int bookingId)
	{
		SeatBooking sb = seatBookingService.getBookingDetailsById(bookingId);
		return  new ResponseEntity<SeatBooking>(sb,HttpStatus.OK);
	} 
//----------------------------------------------------------------------------------------
	@PostMapping(value="/booking",consumes="application/json")
	public HttpStatus addMovieDetails(@RequestBody SeatBooking seatBooking)
	{
		if(seatBookingService.addBookingDetails(seatBooking))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}
//----------------------------------------------------------------------------------------------	
	@PutMapping(consumes="application/json")
	public HttpStatus modifyBookingDetails(@RequestBody SeatBooking seatBooking)
	{
		if(seatBookingService.addBookingDetails(seatBooking))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;	
	}
//--------------------------------------------------------------------------------------------------	
	@DeleteMapping(value="/delete/{bookingId}")
	public HttpStatus deleteMovie(@PathVariable int bookingId)
	{
		seatBookingService.removeBookingByID(bookingId);
		return HttpStatus.OK;
	}
	
//--------------------------------------------------------------------------------------------
	@ExceptionHandler(RuntimeException.class)
	public HttpStatus exceptionHandlerMethod()
	{
		return HttpStatus.NO_CONTENT;
	}
	
}
