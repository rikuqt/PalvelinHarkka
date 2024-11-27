package com.harkka.harkkatyo;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class HarkkatyoController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("teksti", "Harkkatyo");
        return "home";
    }
}
