package com.cg.sprint1.mvtktapp.sample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="class_seats")
public class ClassSeats 
{
	@Id
	@Column(name="class_seats_id ")
	String classSeatsId;
	
	@Column(name="rows")
	String rows;
	
	@Column(name="cols")
	int columnNo;
	
	@Column(name="fare")
	int ticketPrice;
	
	public ClassSeats() {
		super();
	}

	public ClassSeats(String classSeatsId, String rows, int columnNo, int ticketPrice) {
		super();
		this.classSeatsId = classSeatsId;
		this.rows = rows;
		this.columnNo = columnNo;
		this.ticketPrice = ticketPrice;
	}

	public String getClassSeatsId() {
		return classSeatsId;
	}

	public void setClassSeatsId(String classSeatsId) {
		this.classSeatsId = classSeatsId;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public int getColumnNo() {
		return columnNo;
	}

	public void setColumnNo(int columnNo) {
		this.columnNo = columnNo;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	
}
