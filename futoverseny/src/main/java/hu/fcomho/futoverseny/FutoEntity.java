package hu.fcomho.futoverseny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.JoinColumn;
//import java.util.Set;


@Entity
public class FutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long futoId;

    private String futoName;

    private Integer eletkor;

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

    public Integer getEletkor() {
        return eletkor;
    }

    public void setEletkor(Integer eletkor) {
        this.eletkor = eletkor;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}