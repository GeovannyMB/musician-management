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

import br.com.ifms.relacionamento.model.Instrument;
import br.com.ifms.relacionamento.service.InstrumentService;

@Controller
@RequestMapping("/instrument")
public class InstrumentController {

    @Autowired
    InstrumentService instrumentService;

    @PostMapping("/")
    public String save(@ModelAttribute("instrument") Instrument instrument) {
        instrumentService.save(instrument);
        return "redirect:/instrument/";
    }

    @GetMapping("/")
    public String locAll(Model model) {
        List<Instrument> instruments = instrumentService.getInstruments();
        model.addAttribute("instruments", instruments);
        return "instruments";
    }

    @GetMapping("/registerInstrument")
    public String newParent(Model model) {
        model.addAttribute("instrument", new Instrument());
        return "registerInstrument";
    }

    @GetMapping("/remove/{id}")
    public String removeInstrument(@PathVariable("id") UUID id) {
        instrumentService.delete(id);
        return "redirect:/instrument/";
    }

    @GetMapping("/edit/{id}")
    public String editInstrument(@PathVariable("id") UUID id, Model model) {
        Instrument instrument = instrumentService.findById(id);
        model.addAttribute("instrument", instrument);
        return "editInstrument";
    }

    @PostMapping("/update/{id}")
    public String updateInstrument(@PathVariable("id") UUID id, @ModelAttribute Instrument instrument) {
        instrumentService.save(instrument);
        return "redirect:/instrument/";
    }

}