package com.mycompany.hibernatefundamentals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mycompany.hibernatefundamentals.airport.Passenger;
import com.mycompany.hibernatefundamentals.airport.Ticket;

import java.util.List;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m04.ex01");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Passenger john = new Passenger("John Smith");

		Ticket ticket1 = new Ticket("AA1234");
		ticket1.setPassenger(john);

		Ticket ticket2 = new Ticket("BB5678");
		ticket2.setPassenger(john);

		john.addTicket(ticket1);
		john.addTicket(ticket2);

		em.persist(john);

		em.persist(ticket1);
		em.persist(ticket2);

		em.getTransaction().commit();

		List<Passenger> passengers = em.createQuery("From Passenger").getResultList();

		Passenger lazy = passengers.get(0);

		System.out.println(lazy.getTickets().get(0));

		emf.close();

	}

}
