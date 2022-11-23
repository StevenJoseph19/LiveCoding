package com.mycompany.hibernatefundamentals.airport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "TICKETS")
public class Ticket {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	@Column(name = "NUMBER")
	private String number;

	@ManyToMany
	@MapsId
	private List<Passenger> passengers = new ArrayList<>();

	public Ticket(String number) {
		this.number = number;
	}

	public Ticket() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public List<Passenger> getPassengers() {
		return Collections.unmodifiableList(passengers);
	}

	public void addPassenger(Passenger passenger) {
		passengers.add(passenger);
	}

}
