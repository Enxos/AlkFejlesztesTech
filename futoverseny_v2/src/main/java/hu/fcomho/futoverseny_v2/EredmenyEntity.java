package hu.fcomho.futoverseny_v2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.Set;

@Entity
public class EredmenyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eredmenyId;

    // private String futoIdja;
    @ManyToOne
    @JoinColumn(name = "futo_id", referencedColumnName = "futoId")
    private FutoEntity futoIdja;

    private Integer ido;

    @ManyToMany (mappedBy = "versenyEredmenyek")
    @JsonIgnore
    private Set<VersenyEntity> versenyek;


    public Long getEredmenyId() {
        return eredmenyId;
    }

    public void setEredmenyId(Long eredmenyId) {
        this.eredmenyId = eredmenyId;
    }

    public FutoEntity getFutoIdja() {
        return futoIdja;
    }

    public void setFutoIdja(FutoEntity futoIdja) {
        this.futoIdja = futoIdja;
    }

    public Integer getIdo() {
        return ido;
    }

    public void setIdo(Integer ido) {
        this.ido = ido;
    }

    public Set<VersenyEntity> getVersenyek() {
        return versenyek;
    }

    public void setVersenyek(Set<VersenyEntity> versenyek) {
        this.versenyek = versenyek;
    }
    
}
