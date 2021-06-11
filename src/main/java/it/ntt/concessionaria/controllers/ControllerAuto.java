package it.ntt.concessionaria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.ntt.concessionaria.repositories.AutoRepository;

@Controller
public class ControllerAuto {

    private final AutoRepository autoRepository;

    public ControllerAuto(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    // @GetMapping("/automobili")
    // public String getAuto(Model model) {
    //     model.addAttribute("automobili", autoRepository.findAll());
    //     return "auto";
    // }

    @GetMapping("/listaauto")
    public String getAllAutomobili(Model model) {
        model.addAttribute("listaAutomobili", autoRepository.findAll());
        return "listaauto";
    }
    
}
