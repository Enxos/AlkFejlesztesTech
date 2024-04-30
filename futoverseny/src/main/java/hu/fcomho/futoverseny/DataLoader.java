package hu.fcomho.futoverseny;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private FutoRepository futoRepository;

    @Autowired
    private VersenyRepository versenyRepository;

    @Autowired
    private EredmenyRepository eredmenyRepository;

    @Override
    public void run(String... args) throws Exception {
        // Futók generálása
        FutoEntity futo1 = new FutoEntity();
        futo1.setFutoName("Kovács Béla");
        futo1.setEletkor(32);
        futo1.setGender("férfi");
        futoRepository.save(futo1);

        FutoEntity futo2 = new FutoEntity();
        futo2.setFutoName("Nagy Anna");
        futo2.setEletkor(28);
        futo2.setGender("nő");
        futoRepository.save(futo2);
        
        FutoEntity futo3 = new FutoEntity();
        futo3.setFutoName("Szabó Péter");
        futo3.setEletkor(40);
        futoRepository.save(futo3);
        futo3.setGender("férfi");
        futoRepository.save(futo3);
        
        FutoEntity futo4 = new FutoEntity();
        futo4.setFutoName("Kovács Béla");
        futo4.setEletkor(25);
        futo4.setGender("nő");
        futoRepository.save(futo4);
        
        // Versenyek generálása
        VersenyEntity verseny1 = new VersenyEntity();
        verseny1.setVersenyNev("Budapesti Félmaraton");
        verseny1.setTavolsag(21.1);
        versenyRepository.save(verseny1);

        VersenyEntity verseny2 = new VersenyEntity();
        verseny2.setVersenyNev("10 km-es futás");
        verseny2.setTavolsag(10.0);
        versenyRepository.save(verseny2);

        // Eredmények generálása
        EredmenyEntity eredmeny1 = new EredmenyEntity();
        eredmeny1.setFutoId(futo1);
        eredmeny1.setVersenyId(verseny1);
        eredmeny1.setIdoEredmeny(120);
        eredmenyRepository.save(eredmeny1);

        EredmenyEntity eredmeny2 = new EredmenyEntity();
        eredmeny2.setFutoId(futo2);
        eredmeny2.setVersenyId(verseny1);
        eredmeny2.setIdoEredmeny(135);
        eredmenyRepository.save(eredmeny2);

        EredmenyEntity eredmeny3 = new EredmenyEntity();
        eredmeny3.setFutoId(futo3);
        eredmeny3.setVersenyId(verseny2);
        eredmeny3.setIdoEredmeny(55);
        eredmenyRepository.save(eredmeny3);

        EredmenyEntity eredmeny4 = new EredmenyEntity();
        eredmeny4.setFutoId(futo4);
        eredmeny4.setVersenyId(verseny2);
        eredmeny4.setIdoEredmeny(60);
        eredmenyRepository.save(eredmeny4);

        EredmenyEntity eredmeny5 = new EredmenyEntity();
        eredmeny5.setFutoId(futo1);
        eredmeny5.setVersenyId(verseny2);
        eredmeny5.setIdoEredmeny(52);
        eredmenyRepository.save(eredmeny5);

        EredmenyEntity eredmeny6 = new EredmenyEntity();
        eredmeny6.setFutoId(futo2);
        eredmeny6.setVersenyId(verseny1);
        eredmeny6.setIdoEredmeny(128);
        eredmenyRepository.save(eredmeny6);
    }

    /*  
    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
    */

}