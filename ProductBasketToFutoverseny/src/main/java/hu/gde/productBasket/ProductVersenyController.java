package hu.gde.productBasket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;


@RestController
@RequestMapping("/api")
public class ProductVersenyController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private VersenyRepository versenyRepository;

    @GetMapping("/getProducts")
    public List<ProductEntity> getProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/addProduct")
    public ProductEntity addProduct(@RequestBody ProductEntity product) {
        return productRepository.save(product);
    }

    @GetMapping("/getVersenyProducts/{id}")
    public List<ProductEntity> getVersenyProducts(@PathVariable Long id) {
        VersenyEntity verseny = versenyRepository.findById(id).orElseThrow(() -> new RuntimeException("Verseny not found!"));
        return new ArrayList<>(verseny.getVersenyProducts());
    }

    @PutMapping("/updateVersenyName/{versenyId}")
    public VersenyEntity updateVersenyName(@PathVariable Long versenyId, @RequestBody String name) {
        VersenyEntity verseny = versenyRepository.findById(versenyId)
                .orElseThrow(() -> new RuntimeException("Verseny not found with ID: " + versenyId));
        verseny.setVersenyName(name);
        return versenyRepository.save(verseny);
    }
    @PostMapping("/addProductToVerseny/{versenyId}/{productId}")
    public VersenyEntity addProductToVerseny(@PathVariable Long versenyId, @PathVariable Long productId) {
        VersenyEntity verseny = versenyRepository.findById(versenyId)
                .orElseThrow(() -> new RuntimeException("Verseny not found with ID: " + versenyId));
        ProductEntity product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));

        verseny.getVersenyProducts().add(product);
        return versenyRepository.save(verseny);
    }

    @GetMapping("/getVersenyPrice/{versenyId}")
    public Long getVersenyPrice(@PathVariable Long versenyId) {
        VersenyEntity verseny = versenyRepository.findById(versenyId)
                .orElseThrow(() -> new RuntimeException("Verseny not found with ID: " + versenyId));

        long totalPrice = 0;

        for (ProductEntity product : verseny.getVersenyProducts()) {
            totalPrice += product.getPrice();
        }

        return totalPrice;
    }

}
