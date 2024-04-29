package com.fcomho.beadando;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashSet;
import java.util.Set;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@Component
public class DataLoader implements CommandLineRunner {
    /*public static void main(String[] args) {
        SpringApplication.run(FutoversenyApplication.class, args);
    }
*/
    @Autowired
    private FutoRepository futoRepository;

    @Autowired
    private VersenyRepository versenyRepository;

    @Autowired
    private EredmenyRepository eredmenyRepository;

    @Override
    public void generateTestData(String... args) throws Exception {
        // Futók generálása
        Futo futo1 = new Futo();
        futo1.setFutoName("Kovács Béla");
        futo1.setEletkor(32);
        futo1.setGender("férfi");
        FutoRepository.save(futo1);

        Futo futo2 = new Futo();
        futo2.setFutoName("Nagy Anna");
        futo2.setEletkor(28);
        futo2.setGender("nő");
        FutoRepository.save(futo2);
        
        Futo futo3 = new Futo();
        futo3.setFutoName("Szabó Péter");
        futo3.setEletkor(40);
        futo3.setGender("férfi");
        FutoRepository.save(futo3);
        
        Futo futo4 = new Futo();
        futo4.setFutoName("Kovács Béla");
        futo4.setEletkor(25);
        futo4.setGender("nő");
        FutoRepository.save(futo4);
        
        Verseny verseny1 = new Verseny();
        verseny1.setNev("Budapesti Félmaraton");
        verseny1.setTavolsag(21.1);
        VersenyRepository.save(verseny1);

        Verseny verseny2 = new Verseny();
        verseny2.setNev("10 km-es futás");
        verseny2.setTavolsag(10);
        VersenyRepository.save(verseny2);

        Eredmeny eredmeny1 = new Eredmeny();
        eredmeny1.setFutoId(futo1);
        eredmeny1.setVersenyId(verseny1);
        eredmeny1.setIdoEredmeny(120);
        EredmenyRepository.save(eredmeny1);

        Eredmeny eredmeny2 = new Eredmeny();
        eredmeny2.setFutoId(futo2);
        eredmeny2.setVersenyId(verseny1);
        eredmeny2.setIdoEredmeny(135);
        EredmenyRepository.save(eredmeny2);

        Eredmeny eredmeny3 = new Eredmeny();
        eredmeny3.setFutoId(futo3);
        eredmeny3.setVersenyId(verseny2);
        eredmeny3.setIdoEredmeny(55);
        EredmenyRepository.save(eredmeny3);

        Eredmeny eredmeny4 = new Eredmeny();
        eredmeny4.setFutoId(futo4);
        eredmeny4.setVersenyId(verseny2);
        eredmeny4.setIdoEredmeny(60);
        EredmenyRepository.save(eredmeny4);

        Eredmeny eredmeny5 = new Eredmeny();
        eredmeny5.setFutoId(futo1);
        eredmeny5.setVersenyId(verseny2);
        eredmeny5.setIdoEredmeny(52);
        EredmenyRepository.save(eredmeny5);

        Eredmeny eredmeny6 = new Eredmeny();
        eredmeny6.setFutoId(futo2);
        eredmeny6.setVersenyId(verseny1);
        eredmeny6.setIdoEredmeny(128);
        EredmenyRepository.save(eredmeny6);
    }
}



/*
        com.fcomho.beadando.Futo futo1 = new Futo("Kovács Béla", 32, "férfi");
        com.fcomho.beadando.Futo futo2 = new Futo("Nagy Anna", 28, "nő");
        com.fcomho.beadando.Futo futo3 = new Futo("Szabó Péter", 40, "férfi");
        com.fcomho.beadando.Futo futo4 = new Futo("Tóth Zsuzsa", 25, "nő");
        
        futóRepository.saveAll(Arrays.asList(futo1, futo2, futo3, futo4));
 */
        // Versenyek generálása

/*
        Verseny verseny1 = new Verseny("Félmaraton", 21.1);
        Verseny verseny2 = new Verseny("10 km-es futás", 10.0);
*/
/*
        versenyRepository.saveAll(Arrays.asList(verseny1, verseny2));

        // Eredmények generálása
        Eredmény eredmény1 = new Eredmény(futó1, verseny1, 120);
        Eredmény eredmény2 = new Eredmény(futó2, verseny1, 135);
        Eredmény eredmény3 = new Eredmény(futó3, verseny2, 55);
        Eredmény eredmény4 = new Eredmény(futó4, verseny2, 60);
        Eredmény eredmény5 = new Eredmény(futó1, verseny2, 52);
        Eredmény eredmény6 = new Eredmény(futó2, verseny1, 128);

        eredményRepository.saveAll(Arrays.asList(eredmény1, eredmény2, eredmény3, eredmény4, eredmény5, eredmény6));
    }
}
}
 */