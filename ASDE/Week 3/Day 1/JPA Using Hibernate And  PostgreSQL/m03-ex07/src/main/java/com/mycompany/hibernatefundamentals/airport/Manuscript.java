package com.mycompany.hibernatefundamentals.airport;

import javax.persistence.*;

@Entity
public class Manuscript {

    @Id
    private Long id;

    private byte[] file;

    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private Book book;
}
