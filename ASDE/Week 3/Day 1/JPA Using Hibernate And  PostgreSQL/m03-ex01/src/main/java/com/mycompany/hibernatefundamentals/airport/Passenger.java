package com.mycompany.hibernatefundamentals.airport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "PASSENGERS")
@SecondaryTable(name = "ADDRESSES",
				pkJoinColumns = @PrimaryKeyJoinColumn(name ="PASSENGER_ID", referencedColumnName = "PASSENGER_ID"))
public class Passenger {
	@Id
	@Column(name = "PASSENGER_ID")
	private int id;

	@Column(name = "PASSENGER_NAME", table = "PASSENGERS")
	private String name;
	
	@Column(name = "PASSENGER_ADDRESS", table = "ADDRESSES", columnDefinition = "varchar(25) not null")
	private String address;

	
	

	public Passenger(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
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



}
