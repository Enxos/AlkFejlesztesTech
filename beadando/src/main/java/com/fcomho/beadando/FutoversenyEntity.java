package com.fcomho.futoverseny;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.Set;

@Entity
public class FutoversenyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long futoId;

    private String futoName;

    private Long eletkor;

    @ManyToMany(mappedBy = "basketProducts")
    @JsonIgnore
    private Set<BasketEntity> baskets;


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

    public Long getEletkor() {
        return eletkor;
    }

    public void setEletkor(Long eletkor) {
        this.eletkor = eletkor;
    }

    public Set<BasketEntity> getBaskets() {
        return baskets;
    }

    public void setBaskets(Set<BasketEntity> baskets) {
        this.baskets = baskets;
    }
}