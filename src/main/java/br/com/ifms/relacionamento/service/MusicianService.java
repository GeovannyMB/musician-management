package br.com.ifms.relacionamento.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifms.relacionamento.model.Musician;
import br.com.ifms.relacionamento.repository.MusicianRepository;

@Service
public class MusicianService {
    @Autowired
    MusicianRepository musicianRepository;

    public List<Musician> getMusicians() {
        return musicianRepository.findAll();
    }

    public void save(Musician musician) {
        musicianRepository.save(musician);
    }

    public void delete(UUID id) {
        musicianRepository.deleteById(id);
    }

    public Musician findById(UUID id) {
        return musicianRepository.findById(id).get();
    }
}
