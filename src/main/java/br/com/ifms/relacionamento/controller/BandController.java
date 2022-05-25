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

import br.com.ifms.relacionamento.model.Band;
import br.com.ifms.relacionamento.service.BandService;

@Controller
@RequestMapping("/band")
public class BandController {

    @Autowired
    BandService bandService;

    @PostMapping("/")
    public String save(@ModelAttribute("band") Band band) {
        bandService.save(band);
        return "redirect:/band/";
    }

    @GetMapping("/")
    public String locAll(Model model) {
        List<Band> bands = bandService.getBands();
        model.addAttribute("bands", bands);
        return "bands";
    }

    @GetMapping("/registerBand")
    public String newBand(Model model) {
        model.addAttribute("band", new Band());
        return "registerBand";
    }

    @GetMapping("/remove/{id}")
    public String removeBand(@PathVariable("id") UUID id) {
        bandService.delete(id);
        return "redirect:/band/";
    }

    @GetMapping("/edit/{id}")
    public String editBand(@PathVariable("id") UUID id, Model model) {
        Band band = bandService.findById(id);
        model.addAttribute("band", band);
        return "editBand";
    }

    @PostMapping("/update/{id}")
    public String updateBand(@PathVariable("id") UUID id, @ModelAttribute Band band) {
        bandService.save(band);
        return "redirect:/band/";
    }

}