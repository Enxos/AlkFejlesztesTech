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
public class VersenyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assuming auto-increment for id
    private Integer id;

    private String versenyNeve;

    private String tavolsag;

    @OneToMany(mappedBy = "verseny") // Verseny has many Eredmeny instances
    private List<Eredmeny> eredmenyek;

    public Verseny() {
    }

    public Verseny(Integer id, String versenyNeve, String tavolsag) {
        this.id = id;
        this.versenyNeve = versenyNeve;
        this.tavolsag = tavolsag;
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
public class VersenyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long versenyId;

    @ManyToMany
    @JoinTable(
        name = "verseny_eredmeny",
        joinColumns = @JoinColumn(name = "verseny_id"),
        inverseJoinColumns = @JoinColumn(name = "eredmeny_id")
    )
    private Set<EredmenyEntity> versenyEredmenyek;

    private String versenyNev;

    private Double tavolsag;

    public Long getVersenyId() {
        return versenyId;
    }

    public void setVersenyId(Long versenyId) {
        this.versenyId = versenyId;
    }

    public String getVersenyNev() {
        return versenyNev;
    }

    public void setVersenyNev(String versenyNev) {
        this.versenyNev = versenyNev;
    }

    public Double getTavolsag() {
        return tavolsag;
    }

    public void setTavolsag(Double tavolsag) {
        this.tavolsag = tavolsag;
    }

    public Set<EredmenyEntity> getVersenyEredmenyek() {
        return versenyEredmenyek;
    }

    public void setVersenyEredmenyek(Set<EredmenyEntity> versenyEredmenyek) {
        this.versenyEredmenyek = versenyEredmenyek;
    }
}
*/