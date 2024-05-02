package hu.fcomho.futoverseny_v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;



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

    @PostMapping("/addRunner")
    public FutoEntity addRunner(@RequestBody FutoEntity futo) {
        return futoRepository.save(futo);
    }

    @GetMapping("/getRaceRunners/{ID}")
    public List<EredmenyEntity> getRaceRunners(@PathVariable Long ID) {
        VersenyEntity verseny = versenyRepository.findById(ID).orElseThrow(() -> new RuntimeException("Verseny nem talalhato!"));
        List<EredmenyEntity> eredmenyek = new ArrayList<>(verseny.getVersenyEredmenyek());
        eredmenyek.sort(Comparator.comparingInt(EredmenyEntity::getIdo));
        return eredmenyek;
    }
        @PutMapping("/updateRace/{versenyId}")
        public VersenyEntity updateVerseny(@PathVariable Long versenyId, @RequestBody Map<String, Object> updates) {
            VersenyEntity verseny = versenyRepository.findById(versenyId)
                    .orElseThrow(() -> new RuntimeException("Ezzel az ID-vel verseny nem talalhato: " + versenyId));
            if (updates.containsKey("name")) {
                verseny.setVersenyName((String) updates.get("name"));
            }
            if (updates.containsKey("distance")) {
                verseny.setDistance((Double) updates.get("distance"));
            }
            return versenyRepository.save(verseny);
        }        

    @PostMapping("/addResult")
    public EredmenyEntity addEredmeny(@RequestBody EredmenyEntity eredmeny) {
        return eredmenyRepository.save(eredmeny);
    }

    @GetMapping("/getVersenyIdo/{versenyId}")
    public Double getVersenyIdo(@PathVariable Long versenyId) {
        VersenyEntity verseny = versenyRepository.findById(versenyId)
                .orElseThrow(() -> new RuntimeException("Verseny not found with ID: " + versenyId));

        Integer totalIdo = 0;
        int count = 0;

        for (EredmenyEntity eredmeny : verseny.getVersenyEredmenyek()) {
            totalIdo += eredmeny.getIdo();
            count++;
        }

        return count > 0 ? (double) totalIdo / count : 0;
    }

    @GetMapping("/getEredmenyek")
    public List<EredmenyEntity> getEredmenyek() {
        return eredmenyRepository.findAll();
    }
    
    @GetMapping("/getVersenyEredmenyek/{id}")
    public List<EredmenyEntity> getVersenyEredmenyek(@PathVariable Long id) {
        VersenyEntity verseny = versenyRepository.findById(id).orElseThrow(() -> new RuntimeException("Verseny nem talalhato!"));
        return new ArrayList<>(verseny.getVersenyEredmenyek());
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

}
