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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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