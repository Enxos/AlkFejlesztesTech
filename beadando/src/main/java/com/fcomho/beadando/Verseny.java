package com.fcomho.futoverseny;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Verseny {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long versenyId;

    private String nev;

    private Double tavolsag;

}

/*
@Entity
public class Futok {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nev;

    private String eletkor;

    private String nem;

}
*/

/*
@Entity
public class Eredmeny {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private FutoEntity résztvevő;

    @ManyToOne
    private Verseny verseny;

    private Integer időeredmény; // Percekben

}
*/