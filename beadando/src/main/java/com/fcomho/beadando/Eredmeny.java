package com.fcomho.beadando;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Eredmeny {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eredmenyId;
    
    private Long futoId;

    private String VersenyId;

    private Integer idoEredmeny;

    public Long getEredmenyId() {
        return eredmenyId;
    }

    public void setEredmenyId(Long eredmenyId) {
        this.eredmenyId = eredmenyId;
    }

    public Long getFutoId() {
        return futoId;
    }

    public void setFutoId(Long futoId) {
        this.futoId = futoId;
    }
    
    public String getVersenyId() {
        return VersenyId;
    }

    public void setVersenyId(String VersenyId) {
        this.VersenyId = VersenyId;
    }

    public Integer getIdoEredmeny() {
        return idoEredmeny;
    }

    public void setIdoEredmeny(Integer idoEredmeny) {
        this.idoEredmeny = idoEredmeny;
    }
}
