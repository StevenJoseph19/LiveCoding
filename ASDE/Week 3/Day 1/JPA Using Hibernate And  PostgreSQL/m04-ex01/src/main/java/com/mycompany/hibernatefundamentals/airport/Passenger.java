package com.mycompany.hibernatefundamentals.airport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "PASSENGERS")
public class Passenger {
	@Id
	@GeneratedValue
	@Column(name = "PASSENGER_ID")
	private int id;

	@Column(name = "PASSENGER_NAME")
	private String name;

//	@OneToMany(mappedBy = "passenger",cascade = CascadeType.PERSIST)
	@OneToMany(mappedBy = "passenger",  fetch = FetchType.LAZY)
	private List<Ticket> tickets = new ArrayList<>();

	public Passenger(String name) {
		this.name = name;

	}

	public Passenger() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ticket> getTickets() {
		return Collections.unmodifiableList(tickets);
	}

	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}

}
