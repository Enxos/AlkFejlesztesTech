import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.sql.Timestamp;

@Entity
public class EredmenyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assuming auto-increment for id
    private Integer id;

    // private Integer futoUserId; // Renamed for consistency

    // @ManyToOne // Eredmeny belongs to one Futo
    // @JoinColumn(name = "futo_user_id", nullable = false) // Foreign key to Futo.id
    // private Futo futo;

    @ManyToOne // Eredmeny belongs to one Verseny
    @JoinColumn(name = "verseny_id", nullable = false) // Foreign key to Verseny.id
    private Verseny verseny;

    private Timestamp idoeredmeny; // Using Timestamp for database-compatible type

    public Eredmeny() {
    }

    public Eredmeny(Integer id, Integer futoUserId, Verseny verseny, Timestamp idoeredmeny) {
        this.id = id;
        this.futoUserId = futoUserId;
        this.verseny = verseny;
        this.idoeredmeny = idoeredmeny;
    }

    // Getters and setters omitted for brevity (same as before)

    public Futo getFuto() {
        return futo;
    }

    public void setFuto(Futo futo) {
        this.futo = futo;
    }

    public Verseny getVerseny() {
        return verseny;
    }

    public void setVerseny(Verseny verseny) {
        this.verseny = verseny;
    }
}

/*
package hu.fcomho.futoverseny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    private FutoEntity futok;
    //private Set<FutoEntity> futok;

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

    public FutoEntity getFutok() {
        return futok;
    }

    public void setFutok(FutoEntity futok) {
        this.futok = futok;
    }
}

*/