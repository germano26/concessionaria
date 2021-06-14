package it.ntt.concessionaria.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.ntt.concessionaria.models.Auto;
import it.ntt.concessionaria.models.Concessionario;
import it.ntt.concessionaria.repositories.AutoRepository;
import it.ntt.concessionaria.repositories.ConcessionarioRepository;

@Controller
public class ControllerAuto {

    private final AutoRepository autoRepository;
    private final ConcessionarioRepository concessionarioRepository;

    public ControllerAuto(AutoRepository autoRepository, ConcessionarioRepository concessionarioRepository) {
        this.autoRepository = autoRepository;
        this.concessionarioRepository = concessionarioRepository;
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

    @GetMapping("/listaautoconcessionario/{nomeConcessionario}")
    public String getListaAutoConcessionario(Model model, @PathVariable("nomeConcessionario") String nomeConcessionario) {
        List<Auto> listaAuto = new ArrayList<Auto>((Collection<? extends Auto>) autoRepository.findAll());
        List<Auto> listaAutoFiltrate = new ArrayList<Auto>();
        for(int i=0; i<listaAuto.size(); i++) {
            Auto a = listaAuto.get(i);
            if (a.getConcessionario().getNome().equals(nomeConcessionario)) {
                listaAutoFiltrate.add(a); 
            }
        }
        model.addAttribute("listaAutomobili", listaAutoFiltrate);
        return "listaauto";
    }

    @GetMapping("/addauto")
    public String getForm(Model model) {
        model.addAttribute("concessionarie", concessionarioRepository.findAll());
        return "formauto";
    }

    @PostMapping("/addauto")
    // @ResponseBody
    public String addAuto(Auto auto) {
        autoRepository.save(auto);
        return "redirect:/listaauto";
    }
    
}
