package com.cg.sprint1.mvtktapp.sample.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="theatre")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="theatreId")
public class Theatre 
{
	@Id
	@Column(name="theatre_id")
	String theatreId;
	
	@Column(name="theatre_name")
	String theatreName;
	
	@Column(name="theatre_manager")
	String theatreManager;
	
	@OneToOne
	@JoinColumn(name="add_id")
	Address address;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="theatre")
	List<Show> shows;
	
	public Theatre() {}
	public Theatre(String theatreId, String theatreName, String theatreManager, Address address,List<Show> shows)
	{
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.theatreManager = theatreManager;
		this.address = address;
		this.shows=shows;
	}
	public String getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getTheatreManager() {
		return theatreManager;
	}
	public void setTheatreManager(String theatreManager) {
		this.theatreManager = theatreManager;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Show> getShows() {
		return shows;
	}
	public void setShows(List<Show> shows) {
		this.shows = shows;
	}
}





//@JoinColumn(name="theatre_id")