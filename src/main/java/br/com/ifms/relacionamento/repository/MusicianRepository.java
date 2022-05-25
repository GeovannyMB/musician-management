package br.com.ifms.relacionamento.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifms.relacionamento.model.Musician;

@Repository
public interface MusicianRepository extends JpaRepository<Musician, UUID> {

}
