package br.com.ifms.relacionamento.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifms.relacionamento.model.Instrument;
import br.com.ifms.relacionamento.repository.InstrumentRepository;

@Service
public class InstrumentService {
    @Autowired
    InstrumentRepository instrumentRepository;

    public List<Instrument> getInstruments() {
        return instrumentRepository.findAll();
    }

    public void save(Instrument instrument) {
        instrumentRepository.save(instrument);
    }

    public void delete(UUID id) {
        instrumentRepository.deleteById(id);
    }

    public Instrument findById(UUID id) {
        return instrumentRepository.findById(id).get();
    }
}
