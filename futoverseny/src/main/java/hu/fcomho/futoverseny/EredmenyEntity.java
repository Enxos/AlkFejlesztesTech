package hu.fcomho.futoverseny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class EredmenyEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eredmenyId;
    
    private Long futoId;

    private String VersenyId;

    private Integer idoEredmeny;

    @ManyToMany(mappedBy = "versenyEredmenyek")
    @JsonIgnore
    private Set<VersenyEntity> versenyek;
    private Set<FutoEntity> futok;

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
    
    public Set<VersenyEntity> getVersenyek() {
        return versenyek;
    }

    public void setVersenyek(Set<VersenyEntity> versenyek) {
        this.versenyek = versenyek;
    }

    public Set<FutoEntity> getFutok() {
        return futok;
    }

    public void setFutok(Set<FutoEntity> futok) {
        this.futok = futok;
    }
}
