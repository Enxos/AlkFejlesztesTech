package hu.fcomho.futoverseny_v2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.Set;

@Entity
public class EredmenyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eredmenyId;

    private String eredmenyName;

    private Long ido;

    @ManyToMany(mappedBy = "versenyEredmenyek")
    @JsonIgnore
    private Set<VersenyEntity> versenyek;


    public Long getEredmenyId() {
        return eredmenyId;
    }

    public void setEredmenyId(Long eredmenyId) {
        this.eredmenyId = eredmenyId;
    }

    public String getEredmenyName() {
        return eredmenyName;
    }

    public void setEredmenyName(String eredmenyName) {
        this.eredmenyName = eredmenyName;
    }

    public Long getIdo() {
        return ido;
    }

    public void setIdo(Long ido) {
        this.ido = ido;
    }

    public Set<VersenyEntity> getVersenyek() {
        return versenyek;
    }

    public void setVersenyek(Set<VersenyEntity> versenyek) {
        this.versenyek = versenyek;
    }
    
}
