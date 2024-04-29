package com.fcomho.beadando;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
