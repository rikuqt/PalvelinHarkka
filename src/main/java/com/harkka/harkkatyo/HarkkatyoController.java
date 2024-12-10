package com.harkka.harkkatyo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class HarkkatyoController {

    @Autowired
    TapahtumaRepository tapahtumaRepository;

    @Autowired
    HenkiloRepository henkiloRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tapahtumat", tapahtumaRepository.findAll());
        model.addAttribute("henkilot", henkiloRepository.findAll());
        return "home";
    }


    @GetMapping("/tapahtumat/{id}")
    public String tapahtumat(@PathVariable long id, Model model) {
        model.addAttribute("tapahtumaVaraukset", tapahtumaRepository.getOne(id));
        return "tapahtumat";
    }

    @PostMapping("/events/delete/{id}")
    public String deleteEvent(@PathVariable long id) {
        tapahtumaRepository.deleteById(id);
        return "redirect:/";
    }


    @PostMapping("/events/create")
    public String create(@RequestParam String tapahtumaPaikka,
                         @RequestParam String tapahtumaNimi,
                         @RequestParam String mista,
                         @RequestParam String mihin,
                         @RequestParam String nimi) {

        Henkilo henkilo = henkiloRepository.findByNimi(nimi)
                .orElseGet(() -> {
                    Henkilo newHenkilo = new Henkilo();
                    newHenkilo.setNimi(nimi);
                    return henkiloRepository.save(newHenkilo);
                });

        Tapahtuma tapahtuma = new Tapahtuma();
        tapahtuma.setTapahtumaPaikka(tapahtumaPaikka);
        tapahtuma.setTapahtumaNimi(tapahtumaNimi);
        tapahtuma.setMista(mista);
        tapahtuma.setMihin(mihin);
        tapahtuma.getHenkilot().add(henkilo);

        tapahtumaRepository.save(tapahtuma);

        return "redirect:/";
    }
}
