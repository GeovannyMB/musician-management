package br.com.ifms.relacionamento.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

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

    // @ManyToMany(cascade = CascadeType.ALL)
    // @JoinTable(name = "MUSICO_BANDA", joinColumns = { @JoinColumn(name =
    // "MUSICO_ID") })
    // private List<Musician> musicians;
}
