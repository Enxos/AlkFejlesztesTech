package hu.fcomho.futoverseny_v2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import java.util.Set;

@Entity
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

    private String versenyName;
    
    public Long getVersenyId() {
        return versenyId;
    }

    public void setVersenyId(Long versenyId) {
        this.versenyId = versenyId;
    }
    public String getVersenyName() {
        return versenyName;
    }

    public void setVersenyName(String versenyName) {
        this.versenyName = versenyName;
    }

    public Set<EredmenyEntity> getVersenyEredmenyek() {
        return versenyEredmenyek;
    }

    public void setVersenyEredmenyek(Set<EredmenyEntity> versenyEredmenyek) {
        this.versenyEredmenyek = versenyEredmenyek;
    }
}
