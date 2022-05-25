package br.com.ifms.relacionamento.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    String bandName;
    String genre;
}
