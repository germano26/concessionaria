package it.ntt.concessionaria.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.ntt.concessionaria.models.Auto;
import it.ntt.concessionaria.models.Concessionario;
import it.ntt.concessionaria.models.Dipendente;
import it.ntt.concessionaria.models.Regione;
import it.ntt.concessionaria.repositories.AutoRepository;
import it.ntt.concessionaria.repositories.ConcessionarioRepository;
import it.ntt.concessionaria.repositories.DipendenteRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private AutoRepository autoRepository;
    private ConcessionarioRepository concessionarioRepository;
    private DipendenteRepository dipendenteRepository;

    public BootstrapData(AutoRepository autoRepository, ConcessionarioRepository concessionarioRepository, DipendenteRepository dipendenteRepository) {
        this.autoRepository = autoRepository;
        this.concessionarioRepository = concessionarioRepository;
        this.dipendenteRepository = dipendenteRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
        Concessionario c1 = new Concessionario();
        c1.setNome("Motor");
        c1.setVia("Via Roma");
        c1.setCitta("Roma");
        c1.setRegione(Regione.LAZIO);
        c1.setDescrizione("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In semper ipsum ut justo posuere, eu semper eros mattis. Vivamus eu tellus eu arcu rhoncus hendrerit et vitae ligula. Fusce ultricies efficitur turpis. Aenean non ex sollicitudin, gravida leo sit amet, interdum urna. Vestibulum cursus cursus dignissim. Vestibulum congue lacinia magna, non volutpat diam pharetra ac. Proin ultrices ligula vitae nisl gravida eleifend. Etiam dapibus elit sapien, at imperdiet leo ullamcorper rhoncus.");

        Concessionario c2 = new Concessionario();
        c2.setNome("Valentino");
        c2.setVia("Via Padova");
        c2.setCitta("L'Aquila");
        c2.setRegione(Regione.ABRUZZO);
        c2.setDescrizione("Morbi venenatis condimentum arcu. Maecenas sed luctus eros. Integer scelerisque condimentum purus. Integer dictum dui nisl, a vulputate nisl suscipit vitae. Nunc dapibus pulvinar mauris eu interdum. Nam sed orci ultricies, fermentum massa id, tincidunt neque. Etiam id tellus ante. Ut interdum sed sem id efficitur. Praesent tincidunt viverra leo, nec ultricies velit convallis et. Phasellus quis ultrices ligula, in luctus massa. Vestibulum vel quam quis libero mollis dictum sed ac ex. Aenean ultrices fringilla maximus. Nam id tellus non lectus volutpat fringilla at quis augue. Duis mattis pellentesque eleifend. Donec pharetra mattis nisi, rhoncus tincidunt ipsum iaculis dapibus.");

        Auto a1 = new Auto();
        a1.setModello("Panda");
        a1.setPrezzo((double) 13000);
        a1.setConcessionario(c1);

        Auto a2 = new Auto();
        a2.setModello("Tipo");
        a2.setPrezzo((double) 20000);
        a2.setConcessionario(c2);

        Dipendente d1 = new Dipendente();
        d1.setNome("Mario");
        d1.setCognome("Rossi");
        d1.setEta(55);
        d1.setStipendio((double) 1500);
        d1.setConcessionario(c1);

        Dipendente d2 = new Dipendente();
        d2.setNome("Marco");
        d2.setCognome("Verdi");
        d2.setEta(30);
        d2.setStipendio((double) 1550);
        d2.setConcessionario(c2);

        c1.getListaDipendenti().add(d1);
        c2.getListaDipendenti().add(d2);

        c1.getListaAuto().add(a1);
        c2.getListaAuto().add(a2);

        concessionarioRepository.save(c1);
        concessionarioRepository.save(c2);

        autoRepository.save(a1);
        autoRepository.save(a2);

        dipendenteRepository.save(d1);
        dipendenteRepository.save(d2);

    }
    
}
