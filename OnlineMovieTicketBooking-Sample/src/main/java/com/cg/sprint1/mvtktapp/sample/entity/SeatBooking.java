package com.cg.sprint1.mvtktapp.sample.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="seat_booking")
public class SeatBooking 
{
	@Id
	@Column(name="booking_id")
	int bookingId;
	
	@Column(name="cust_mobileno")
	String customerMobileId;
	
	@Column(name="booking_date")
	String bookingDate;
	
	@Column(name="show_date")
	String showDate;
	
	@Column(name="show_theatre_id")
	String showTheatreId;
	
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="show_theatre_id",updatable=false,insertable=false)
	Show show;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="seatBooking",cascade=CascadeType.REMOVE)
	List<BookedSeats> bookedSeats;

	public SeatBooking() {}
	public SeatBooking(int bookingId, String customerMobileId,String showTheatreId,String bookingDate,String showDate,List<BookedSeats> bookedSeats) 
	{
		super();
		this.bookingId = bookingId;
		this.customerMobileId = customerMobileId;
		this.bookingDate = bookingDate;
		this.showTheatreId=showTheatreId;
		this.showDate = showDate;
		this.bookedSeats= bookedSeats;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getCustomerMobileId() {
		return customerMobileId;
	}

	public void setCustomerMobileId(String customerMobileId) {
		this.customerMobileId = customerMobileId;
	}


	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getShowDate() {
		return showDate;
	}

	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}

	public List<BookedSeats> getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(List<BookedSeats> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	public String getShowTheatreId() {
		return showTheatreId;
	}
	public void setShowTheatreId(String showTheatreId) {
		this.showTheatreId = showTheatreId;
	}
}
