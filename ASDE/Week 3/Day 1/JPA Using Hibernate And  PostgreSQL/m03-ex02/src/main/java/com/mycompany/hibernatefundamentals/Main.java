package com.mycompany.hibernatefundamentals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mycompany.hibernatefundamentals.airport.Passenger;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m03.ex02");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Passenger speedy = new Passenger(2, "Speedy Gonzales");
		speedy.setCity("Delhi");
		speedy.setStreet("Marshall Street");
		speedy.setNumber("3");
		speedy.setZipCode("155656626");

		em.persist(speedy);

		em.getTransaction().commit();
		emf.close();

	}

}
