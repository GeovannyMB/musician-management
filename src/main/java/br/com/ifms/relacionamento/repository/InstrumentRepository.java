package br.com.ifms.relacionamento.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifms.relacionamento.model.Instrument;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, UUID> {

}