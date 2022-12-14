package com.mycompany.hibernatefundamentals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mycompany.hibernatefundamentals.airport.Passenger;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m05.ex06");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		Passenger john = new Passenger("John Smith");
		john.setVip(true);

		
		Passenger mike = new Passenger("Michael Johnson");
		mike.setVip(false);

		

		em.persist(john);
		em.persist(mike);

		em.getTransaction().commit();
		emf.close();

	}

}
