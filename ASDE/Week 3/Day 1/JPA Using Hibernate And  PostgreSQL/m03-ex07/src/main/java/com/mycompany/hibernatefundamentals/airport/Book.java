package com.mycompany.hibernatefundamentals.airport;

import javax.persistence.*;

@Entity
@Table(name = "BOOKS")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "book_seq")
	private Long id;

	private String title;

	private Manuscript manuscript;



	public Book() {

	}

	public Long getId() {
		return id;
	}

	public void setIdr(Long id) {
		this.id= id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Manuscript getManuscript() {
		return manuscript;
	}

	public void setManuscript(Manuscript manuscript) {
		this.manuscript = manuscript;
	}
}
