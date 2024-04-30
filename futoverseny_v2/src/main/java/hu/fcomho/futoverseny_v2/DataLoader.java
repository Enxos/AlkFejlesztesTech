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
        VersenyEntity verseny1 = new VersenyEntity();
        verseny1.setVersenyName("Budapest Maraton");
        verseny1.setVersenyId(1L);
        versenyRepository.save(verseny1);

        VersenyEntity verseny2 = new VersenyEntity();
        verseny2.setVersenyName("verseny2");
        verseny2.setVersenyId(2L);
        versenyRepository.save(verseny2);

        EredmenyEntity eredmeny1 = new EredmenyEntity();
        eredmeny1.setEredmenyName("eredmeny1");
        eredmeny1.setIdo(1L);
        eredmenyRepository.save(eredmeny1);

        EredmenyEntity eredmeny2 = new EredmenyEntity();
        eredmeny2.setEredmenyName("eredmeny2");
        eredmeny2.setIdo(2L);
        eredmenyRepository.save(eredmeny2);

        Set<VersenyEntity> versenyek1 = new HashSet<>();
        versenyek1.add(verseny1);
        versenyek1.add(verseny2);
        eredmeny1.setVersenyek(versenyek1);
        eredmenyRepository.save(eredmeny1);

        Set<VersenyEntity> versenyek2 = new HashSet<>();
        versenyek2.add(verseny1);
        eredmeny2.setVersenyek(versenyek2);
        eredmenyRepository.save(eredmeny2);
    }




}
