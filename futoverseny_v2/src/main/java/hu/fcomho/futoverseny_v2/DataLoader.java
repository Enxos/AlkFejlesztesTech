package hu.fcomho.futoverseny_v2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    
    @Autowired
    private VersenyRepository versenyRepository;

    @Autowired
    private EredmenyRepository eredmenyRepository;

    @Autowired
    private FutoRepository futoRepository;

    @Override
    public void run(String... args) throws Exception {

        // Futók generálása

        FutoEntity futo1 = new FutoEntity();
        futo1.setFutoName("Sonic");
        futo1.setEletkor(25);
        futo1.setGender("Male");
        // futo1.setEredmenyek(Arrays.asList(eredmeny1, eredmeny3));
        futoRepository.save(futo1);

        FutoEntity futo2 = new FutoEntity();
        futo2.setFutoName("Flash");
        futo2.setEletkor(30);
        futo2.setGender("Male");
        // futo2.setEredmenyek(Arrays.asList(eredmeny2));
        futoRepository.save(futo2);

        FutoEntity futo3 = new FutoEntity();
        futo3.setFutoName("Quicksilver");
        futo3.setEletkor(35);
        futo3.setGender("Male");
        // futo3.setEredmenyek(Arrays.asList(eredmeny4));
        futoRepository.save(futo3);

        FutoEntity futo4 = new FutoEntity();
        futo4.setFutoName("Usain Bolt");
        futo4.setEletkor(40);
        futo4.setGender("Male");
        // futo4.setEredmenyek(new ArrayList<>()); // Meg nem fejezett be egy versenyt sem.
        futoRepository.save(futo4);


        // Eredmények generálása

        EredmenyEntity eredmeny1 = new EredmenyEntity();
        FutoEntity futoeredmeny1 = futoRepository.findById(1L).orElse(null);
        if (futoeredmeny1 != null) {
            eredmeny1.setFutoIdja(futoeredmeny1);
        } else {
            // Handle the case where no FutoEntity with futoId 1 exists
        }
        eredmeny1.setIdo(35);
        eredmenyRepository.save(eredmeny1);

        EredmenyEntity eredmeny2 = new EredmenyEntity();
        FutoEntity futoeredmeny2 = futoRepository.findById(2L).orElse(null);
        if (futoeredmeny2 != null) {
            eredmeny2.setFutoIdja(futoeredmeny2);
        } else {
            // Handle the case where no FutoEntity with futoId 1 exists
        }
        eredmeny2.setIdo(42);
        eredmenyRepository.save(eredmeny2);

        EredmenyEntity eredmeny3 = new EredmenyEntity();
        FutoEntity futoeredmeny3 = futoRepository.findById(3L).orElse(null);
        if (futoeredmeny3 != null) {
            eredmeny3.setFutoIdja(futoeredmeny3);
        } else {
            // Handle the case where no FutoEntity with futoId 1 exists
        }
        eredmeny3.setIdo(37);
        eredmenyRepository.save(eredmeny3);

        EredmenyEntity eredmeny4 = new EredmenyEntity();
        FutoEntity futoeredmeny4 = futoRepository.findById(4L).orElse(null);
        if (futoeredmeny4 != null) {
            eredmeny4.setFutoIdja(futoeredmeny4);
        } else {
            // Handle the case where no FutoEntity with futoId 1 exists
        }
        eredmeny4.setIdo(32);
        eredmenyRepository.save(eredmeny4);

        // Futók hozzárendelése eredményekhez

        // Versenyek generálása és eredmények hozzárendelése a versenyekhez
        
        VersenyEntity verseny1 = new VersenyEntity();
        Set<EredmenyEntity> verseny1Eredmenyek = new HashSet<>();
        verseny1Eredmenyek.add(eredmeny1);
        verseny1Eredmenyek.add(eredmeny2);
        verseny1.setVersenyEredmenyek(verseny1Eredmenyek);
        verseny1.setVersenyName("Budapest Félmaraton");
        verseny1.setDistance(21.1);
        versenyRepository.save(verseny1);

        VersenyEntity verseny2 = new VersenyEntity();
        Set<EredmenyEntity> verseny2Eredmenyek = new HashSet<>();
        verseny2Eredmenyek.add(eredmeny3);
        verseny2Eredmenyek.add(eredmeny4);
        verseny2.setVersenyEredmenyek(verseny2Eredmenyek);
        verseny2.setVersenyName("10 km-es futás");
        verseny2.setDistance(10.0);
        versenyRepository.save(verseny2);

    }




}
