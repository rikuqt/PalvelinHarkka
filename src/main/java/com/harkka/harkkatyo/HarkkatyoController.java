package com.harkka.harkkatyo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class HarkkatyoController {

    @Autowired
    TapahtumaRepository tapahtumaRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tapahtuma", tapahtumaRepository.findAll());
        return "home";
    }
    @PostMapping("/events/create")
    public String create(@RequestParam String tapahtumaNimi, @RequestParam String tapahtumaPaikka,
                         @RequestParam String mista, @RequestParam String mihin) {
        tapahtumaRepository.save(new Tapahtuma(tapahtumaNimi,tapahtumaPaikka, mista, mihin));
        return "redirect:/";
    }
}
