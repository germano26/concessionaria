package it.ntt.concessionaria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
