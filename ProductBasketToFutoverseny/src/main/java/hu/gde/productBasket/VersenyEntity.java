package hu.gde.productBasket;

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
            name = "verseny_product",
            joinColumns = @JoinColumn(name = "verseny_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<ProductEntity> versenyProducts;

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

    public Set<ProductEntity> getVersenyProducts() {
        return versenyProducts;
    }

    public void setVersenyProducts(Set<ProductEntity> versenyProducts) {
        this.versenyProducts = versenyProducts;
    }
}
