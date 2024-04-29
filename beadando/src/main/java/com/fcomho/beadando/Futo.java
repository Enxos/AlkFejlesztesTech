package com.fcomho.beadando;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.Set;
import jakarta.persistence.GeneratedValue; // Import the GeneratedValue class

@Entity
public class Futo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long futoId;

    private String futoName;

    private Byte eletkor;

    private String gender;


    public Long getFutoId() {
        return futoId;
    }

    public void setFutoId(Long futoId) {
        this.futoId = futoId;
    }

    public String getFutoName() {
        return futoName;
    }

    public void setFutoName(String futoName) {
        this.futoName = futoName;
    }

    public Byte getEletkor() {
        return eletkor;
    }

    public void setEletkor(Byte eletkor) {
        this.eletkor = eletkor;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}