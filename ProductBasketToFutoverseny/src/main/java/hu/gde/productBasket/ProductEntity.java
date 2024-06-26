package hu.gde.productBasket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.Set;

@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    private String productName;

    private Integer price;

    @ManyToMany(mappedBy = "versenyProducts")
    @JsonIgnore
    private Set<VersenyEntity> versenyek;


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Set<VersenyEntity> getVersenyek() {
        return versenyek;
    }

    public void setVersenyek(Set<VersenyEntity> versenyek) {
        this.versenyek = versenyek;
    }
}
