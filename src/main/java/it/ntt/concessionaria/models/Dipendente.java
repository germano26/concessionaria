package it.ntt.concessionaria.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity
public class Dipendente {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Concessionario concessionario;

    @NonNull
    @Size(min = 1)
    private String nome;

    @NonNull
    @Size(min = 1)
    private String cognome;

    private Double stipendio;

    @NonNull
    @Min(16)
    private Integer eta;

    public Dipendente () {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Concessionario getConcessionario() {
        return concessionario;
    }
    public void setConcessionario(Concessionario concessionario) {
        this.concessionario = concessionario;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public Double getStipendio() {
        return stipendio;
    }
    public void setStipendio(Double stipendio) {
        this.stipendio = stipendio;
    }
    public Integer getEta() {
        return eta;
    }
    public void setEta(Integer eta) {
        this.eta = eta;
    }





}
