package it.ntt.concessionaria.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Concessionario {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Size(min = 1)
    private String nome;

    @NonNull
    @Size(min = 1)
    private String via;

    @NonNull
    @Size(min = 1)
    private String citta;

    @NonNull
    private Regione regione;

    @NonNull
    @Column(length = 1000)
    private String descrizione;

    @OneToMany(mappedBy = "concessionario")
    private Set<Dipendente> listaDipendenti = new HashSet<>();

    @OneToMany(mappedBy = "concessionario")
    private Set<Auto> listaAuto = new HashSet<>();

    public String getUrlDettaglio() {
        return "/concessionario/" + id.toString();
    }
    
}
