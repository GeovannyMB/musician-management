package br.com.ifms.relacionamento.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ifms.relacionamento.model.Musician;
import br.com.ifms.relacionamento.service.MusicianService;

@Controller
@RequestMapping("/musician")
public class MusicianController {

    @Autowired
    MusicianService musicianService;

    @PostMapping("/")
    public String save(@ModelAttribute("musician") Musician musician) {
        musicianService.save(musician);
        return "redirect:/musician/";
    }

    @GetMapping("/")
    public String locAll(Model model) {
        List<Musician> musicians = musicianService.getMusicians();
        model.addAttribute("musicians", musicians);
        return "musicians";
    }

    @GetMapping("/registerMusician")
    public String newParent(Model model) {
        model.addAttribute("musician", new Musician());
        return "registerMusician";
    }

    @GetMapping("/remove/{id}")
    public String removeMusician(@PathVariable("id") UUID id) {
        musicianService.delete(id);
        return "redirect:/musician/";
    }

    @GetMapping("/edit/{id}")
    public String editMusician(@PathVariable("id") UUID id, Model model) {
        Musician musician = musicianService.findById(id);
        model.addAttribute("musician", musician);
        return "editMusician";
    }

    @PostMapping("/update/{id}")
    public String updateMusician(@PathVariable("id") UUID id, @ModelAttribute Musician musician) {
        musicianService.save(musician);
        return "redirect:/musician/";
    }

}