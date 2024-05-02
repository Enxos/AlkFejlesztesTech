package hu.fcomho.futoverseny_v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EredmenyVersenyFrontendController {
    @Autowired
    private VersenyRepository versenyRepository;
    @Autowired
    private EredmenyRepository eredmenyRepository;
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
    public String vieweredmenyek(@PathVariable Long id, Model model) {
        VersenyEntity verseny = versenyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Verseny not found with ID: " + id));

        model.addAttribute("eredmenyek", verseny.getVersenyEredmenyek());
        return "eredmenyek";
    }

}
