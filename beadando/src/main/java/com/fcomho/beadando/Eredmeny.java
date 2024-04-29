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

}
