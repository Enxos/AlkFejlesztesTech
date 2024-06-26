package hu.gde.productBasket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductVersenyFrontendController {
    @Autowired
    private VersenyRepository versenyRepository;
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/versenyek")
    public String getAllVersenyek(Model model) {
        List<VersenyEntity> versenyek = versenyRepository.findAll();
        model.addAttribute("versenyek", versenyek);
        return "versenyek";
    }

    @PostMapping("/createVerseny")
    public String createVerseny(@RequestParam("name") String name) {
        VersenyEntity newVerseny = new VersenyEntity();
        newVerseny.setVersenyName(name);
        versenyRepository.save(newVerseny);
        return "redirect:/versenyek";
    }

    @GetMapping("/verseny/{id}")
    public String viewVersenyDetails(@PathVariable Long id, Model model) {
        VersenyEntity verseny = versenyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Verseny not found with ID: " + id));

        model.addAttribute("products", verseny.getVersenyProducts());
        return "versenyDetails";
    }

}
