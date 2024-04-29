package com.fcomho.futoverseny;

@Entity
public class Futok {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nev;

    private String eletkor;

    private String nem;

}

@Entity
public class Verseny {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nev;

    private Double tavolsag;

    // További attribútumok, pl. leírás, dátum

}

@Entity
public class Eredmeny {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private FutoversenyEntity résztvevő;

    @ManyToOne
    private Verseny verseny;

    private Integer időeredmény; // Percekben

}
