package hu.gde.productBasket;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private BasketRepository basketRepository;

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

        BasketEntity basket1 = new BasketEntity();
        Set<ProductEntity> basket1Products = new HashSet<>();
        basket1Products.add(product1);
        basket1Products.add(product2);
        basket1.setBasketProducts(basket1Products);
        basket1.setBasketName("Budapesti Félmaraton");
        basketRepository.save(basket1);

        BasketEntity basket2 = new BasketEntity();
        Set<ProductEntity> basket2Products = new HashSet<>();
        basket2Products.add(product3);
        basket2Products.add(product4);
        basket2.setBasketProducts(basket2Products);
        basket2.setBasketName("10Km-es futás");
        basketRepository.save(basket2);
    }
}
