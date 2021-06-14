package it.ntt.concessionaria.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.ntt.concessionaria.models.Concessionario;
// import antlr.collections.List;
// import it.ntt.concessionaria.models.Concessionario;
import it.ntt.concessionaria.repositories.ConcessionarioRepository;

@Controller
public class ControllerConcessionari {
    
    private ConcessionarioRepository concessionarioRepository;

    public ControllerConcessionari (ConcessionarioRepository concessionarioRepository) {
        this.concessionarioRepository = concessionarioRepository;
    }

    @GetMapping("/listaconcessionari")
    public String getAllConcessionari(Model model) {
        // Set<Concessionario> listaConcessionari = new HashSet<>();
        // listaConcessionari.addAll(concessionarioRepository.findAll());
        model.addAttribute("listaConcessionari", concessionarioRepository.findAll());
        return "listaconcessionari";
    }

    @GetMapping("/concessionario/{id}")
    public String getDettaglioConcessionario(@PathVariable("id") Long id, Model model) {
        Optional<Concessionario> optional = concessionarioRepository.findById(id);
        if (optional.isPresent()) {
            Concessionario c = optional.get();
            model.addAttribute("nomeconcessionario", c.getNome());
            model.addAttribute("descrizioneconcessionario", c.getDescrizione());
        } else {
            model.addAttribute("descrizioneconcessionario", "ID non trovato!");
        }
        return "dettaglioconcessionario";
    }
}
