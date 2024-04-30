package hu.fcomho.futoverseny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import java.util.Set;

@Entity
public class FutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assuming auto-increment for id
    private Integer id;

    private String nev;

    private Byte eletkor; // Using Byte for database-compatible type

    private Integer gender; // Assuming gender is stored as an integer

    @OneToMany(mappedBy = "futo") // Futo has many Eredmeny instances
    private List<Eredmeny> eredmenyek;

    public Futo() {
    }

    public Futo(Integer id, String nev, Byte eletkor, Integer gender) {
        this.id = id;
        this.nev = nev;
        this.eletkor = eletkor;
        this.gender = gender;
        this.eredmenyek = new ArrayList<>();
    }

    // Getters and setters omitted for brevity (same as before)

    public List<Eredmeny> getEredmenyek() {
        return eredmenyek;
    }

    public void setEredmenyek(List<Eredmeny> eredmenyek) {
        this.eredmenyek = eredmenyek;
    }
}


/*
public class FutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long futoId;

    @ManyToMany
    @JoinTable(
        name = "futo_eredmeny",
        joinColumns = @JoinColumn(name = "futo_id"),
        inverseJoinColumns = @JoinColumn(name = "eredmeny_id")
    )
    private Set<EredmenyEntity> futoEredmenyek;

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
*/