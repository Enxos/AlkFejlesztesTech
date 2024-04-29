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
        futo1.setFutoName(futoName:"Kovács Béla");
        futo1.setEletkor(32);
        futo1.setGender(gender:"férfi");





        com.fcomho.beadando.Futo futo1 = new Futo("Kovács Béla", 32, "férfi");
        com.fcomho.beadando.Futo futo2 = new Futo("Nagy Anna", 28, "nő");
        com.fcomho.beadando.Futo futo3 = new Futo("Szabó Péter", 40, "férfi");
        com.fcomho.beadando.Futo futo4 = new Futo("Tóth Zsuzsa", 25, "nő");
        
        futóRepository.saveAll(Arrays.asList(futo1, futo2, futo3, futo4));

        // Versenyek generálása
        Verseny verseny1 = new Verseny("Félmaraton", 21.1);
        Verseny verseny2 = new Verseny("10 km-es futás", 10.0);

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
