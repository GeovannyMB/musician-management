package br.com.ifms.relacionamento.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifms.relacionamento.model.Band;
import br.com.ifms.relacionamento.repository.BandRepository;

@Service
public class BandService {
    @Autowired
    BandRepository bandRepository;

    public List<Band> getBands() {
        return bandRepository.findAll();
    }

    public void save(Band band) {
        bandRepository.save(band);
    }

    public void delete(UUID id) {
        bandRepository.deleteById(id);
    }

    public Band findById(UUID id) {
        return bandRepository.findById(id).get();
    }
}
