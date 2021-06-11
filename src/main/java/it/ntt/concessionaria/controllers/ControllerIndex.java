package it.ntt.concessionaria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.ntt.concessionaria.repositories.ConcessionarioRepository;

@Controller
public class ControllerIndex {
    
    private final ConcessionarioRepository concessionarioRepository;

    public ControllerIndex(ConcessionarioRepository concessionarioRepository) {
        this.concessionarioRepository = concessionarioRepository;
    }

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("numeroRegioni", concessionarioRepository.countRegion());
        return "index";
    }
}
