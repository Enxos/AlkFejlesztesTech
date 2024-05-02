package hu.fcomho.futoverseny_v2;

// import com.fasterxml.jackson.annotation.JsonIgnore; // Nem tudom, hogy kell-e?
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Set;


@Entity
public class FutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long futoId;

    @OneToMany(mappedBy = "futoIdja")
    private Set<EredmenyEntity> eredmenyek;

    private String futoName;

    private Integer eletkor;

    private String gender;
/*
    @OneToMany // (mappedBy = "futoEredmenyek") //ManyToMany-nel volt hasznalva a masik oldalon... 
    @JoinTable(
            name = "futo_eredmeny",
            joinColumns = @JoinColumn(name = "futoId"),
            inverseJoinColumns = @JoinColumn(name = "futoIdja")
    )
    private Set<EredmenyEntity> futoEredmenyek;
*/  
    // @JsonIgnore Nem tudom, hogy kell-e?

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
    /*
    public Set<EredmenyEntity> getFutoEredmenyek() {
        return futoEredmenyek;
    }

    public void setFutoEredmenyek(Set<EredmenyEntity> futoEredmenyek) {
        this.futoEredmenyek = futoEredmenyek;
    }
    */
}