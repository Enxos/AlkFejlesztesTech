package hu.gde.productBasket;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private VersenyRepository versenyRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        ProductEntity product1 = new ProductEntity();
        product1.setProductName("Első helyezett Futó");
        product1.setPrice(65);
        productRepository.save(product1);

        ProductEntity product2 = new ProductEntity();
        product2.setProductName("Második helyezett Futó");
        product2.setPrice(75);
        productRepository.save(product2);

        ProductEntity product3 = new ProductEntity();
        product3.setProductName("Harmadik helyezett Futó");
        product3.setPrice(76);
        productRepository.save(product3);

        ProductEntity product4 = new ProductEntity();
        product4.setProductName("Negyedik helyezett Futó");
        product4.setPrice(81);
        productRepository.save(product4);

        VersenyEntity verseny1 = new VersenyEntity();
        Set<ProductEntity> verseny1Products = new HashSet<>();
        verseny1Products.add(product1);
        verseny1Products.add(product2);
        verseny1.setVersenyProducts(verseny1Products);
        verseny1.setVersenyName("Budapesti Félmaraton");
        versenyRepository.save(verseny1);

        VersenyEntity verseny2 = new VersenyEntity();
        Set<ProductEntity> verseny2Products = new HashSet<>();
        verseny2Products.add(product3);
        verseny2Products.add(product4);
        verseny2.setVersenyProducts(verseny2Products);
        verseny2.setVersenyName("10Km-es futás");
        versenyRepository.save(verseny2);
    }
}
