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

    public Long getVersenyId() {
        return futoId;
    }

    public void setVersenyId(Long versenyId) {
        this.versenyId = versenyId;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Double getTavolsag() {
        return tavolsag;
    }

    public void setTavolsag(Double tavolsag) {
        this.tavolsag = tavolsag;
    }
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