package com.fcomho.futoverseny;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Futo

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long futoId;

    private String futoName;

    private Byte eletkor;

    private String nem;


    public Long getfutoId() {
        return futoId;
    }

    public void setfutoId(Long futoId) {
        this.futoId = futoId;
    }

    public String getfutoName() {
        return futoName;
    }

    public void setfutoName(String futoName) {
        this.futoName = futoName;
    }

    public Byte getEletkor() {
        return eletkor;
    }

    public void setEletkor(Byte eletkor) {
        this.eletkor = eletkor;
    }

    public String getnem() {
        return nem;
    }

    public void setnem(String nem) {
        this.nem = nem;
    }
}