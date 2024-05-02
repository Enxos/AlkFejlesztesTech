package hu.fcomho.futoverseny_v2;

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
    private EredmenyRepository eredmenyRepository;

    @Override
    public void run(String... args) throws Exception {

        // Versenyek generálása
        
        /*
        VersenyEntity verseny1 = new VersenyEntity();
        verseny1.setVersenyName("Budapest Félmaraton");
        verseny1.setVersenyId(1L);
        versenyRepository.save(verseny1);

        VersenyEntity verseny2 = new VersenyEntity();
        verseny2.setVersenyName("10 km-es futás");
        verseny2.setVersenyId(2L);
        versenyRepository.save(verseny2);
         */

        // Eredmények generálása
        EredmenyEntity eredmeny1 = new EredmenyEntity();
        eredmeny1.setEredmenyName("eredmeny1");
        eredmeny1.setIdo(1L);
        eredmenyRepository.save(eredmeny1);

        EredmenyEntity eredmeny2 = new EredmenyEntity();
        eredmeny2.setEredmenyName("eredmeny2");
        eredmeny2.setIdo(2L);
        eredmenyRepository.save(eredmeny2);

        EredmenyEntity eredmeny3 = new EredmenyEntity();
        eredmeny3.setEredmenyName("eredmeny3");
        eredmeny3.setIdo(3L);
        eredmenyRepository.save(eredmeny3);

        EredmenyEntity eredmeny4 = new EredmenyEntity();
        eredmeny4.setEredmenyName("eredmeny4");
        eredmeny4.setIdo(4L);
        eredmenyRepository.save(eredmeny4);

        // Futók generálása

        // Futók hozzárendelése eredményekhez

        // Versenyek generálása és eredmények hozzárendelése a versenyekhez
        VersenyEntity verseny1 = new VersenyEntity();
        Set<EredmenyEntity> verseny1Eredmenyek = new HashSet<>();
        verseny1Eredmenyek.add(eredmeny1);
        verseny1Eredmenyek.add(eredmeny2);
        verseny1.setVersenyEredmenyek(verseny1Eredmenyek);
        verseny1.setVersenyName("Budapest Félmaraton");
        versenyRepository.save(verseny1);

        VersenyEntity verseny2 = new VersenyEntity();
        Set<EredmenyEntity> verseny2Eredmenyek = new HashSet<>();
        verseny2Eredmenyek.add(eredmeny3);
        verseny2Eredmenyek.add(eredmeny4);
        verseny2.setVersenyEredmenyek(verseny2Eredmenyek);
        verseny2.setVersenyName("10 km-es futás");
        versenyRepository.save(verseny2);

    }




}
