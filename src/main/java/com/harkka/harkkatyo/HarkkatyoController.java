package com.harkka.harkkatyo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@SpringBootApplication
@Controller
public class HarkkatyoController {

    @Autowired
    TapahtumaRepository tapahtumaRepository;

    @Autowired
    HenkiloRepository henkiloRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tapahtuma", tapahtumaRepository.findAll());
        return "home";
    }

    @PostMapping("/events/create")
    public String create(@PathVariable Long tapahtumaId) {
        Henkilo p = henkiloRepository.getOne(henkiloId);
        Tapahtuma t = new Tapahtuma(new);
        tapahtumaRepository.save(t);
        return "redirect:/";
    }
}
