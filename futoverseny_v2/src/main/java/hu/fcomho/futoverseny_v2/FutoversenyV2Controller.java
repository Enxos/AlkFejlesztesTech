package hu.fcomho.futoverseny_v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api")
public class FutoversenyV2Controller {
    
    @Autowired
    private EredmenyRepository eredmenyRepository;

    @Autowired
    private VersenyRepository versenyRepository;

    @Autowired
    private FutoRepository futoRepository;

    @GetMapping("/getRunners")
    public List<FutoEntity> getRunners() {
        return futoRepository.findAll();
    }

    @GetMapping("/getEredmenyek")
    public List<EredmenyEntity> getEredmenyek() {
        return eredmenyRepository.findAll();
    }

    @PostMapping("/addEredmeny")
    public EredmenyEntity addEredmeny(@RequestBody EredmenyEntity eredmeny) {
        return eredmenyRepository.save(eredmeny);
    }
    
    @GetMapping("/getVersenyEredmenyek/{id}")
    public List<EredmenyEntity> getVersenyEredmenyek(@PathVariable Long id) {
        VersenyEntity verseny = versenyRepository.findById(id).orElseThrow(() -> new RuntimeException("Verseny nem talalhato!"));
        return new ArrayList<>(verseny.getVersenyEredmenyek());
    }

    @PutMapping("/updateVersenyName/{versenyId}")
    public VersenyEntity updateVersenyName(@PathVariable Long versenyId, @RequestBody String name) {
        VersenyEntity verseny = versenyRepository.findById(versenyId)
                .orElseThrow(() -> new RuntimeException("Ezzel az ID-vel verseny nem talalhato: " + versenyId));
        verseny.setVersenyName(name);
        return versenyRepository.save(verseny);
    }

    @PostMapping("/addEredmenyToVerseny/{versenyId}/{eredmenyId}")
    public VersenyEntity addEredmenyToVerseny(@PathVariable Long versenyId, @PathVariable Long eredmenyId) {
        VersenyEntity verseny = versenyRepository.findById(versenyId)
                .orElseThrow(() -> new RuntimeException("Verseny not found with ID: " + versenyId));
        EredmenyEntity eredmeny = eredmenyRepository.findById(eredmenyId)
                .orElseThrow(() -> new RuntimeException("Eredmeny not found with ID: " + eredmenyId));

        verseny.getVersenyEredmenyek().add(eredmeny);
        return versenyRepository.save(verseny);
    }

    @GetMapping("/getVersenyIdo/{versenyId}")
    public Integer getVersenyIdo(@PathVariable Long versenyId) {
        VersenyEntity verseny = versenyRepository.findById(versenyId)
                .orElseThrow(() -> new RuntimeException("Verseny not found with ID: " + versenyId));

        Integer totalIdo = 0;

        for (EredmenyEntity eredmeny : verseny.getVersenyEredmenyek()) {
            totalIdo += eredmeny.getIdo();
        }

        return totalIdo;
    }

}
