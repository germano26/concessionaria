package it.ntt.concessionaria.repositories;

import org.springframework.data.repository.CrudRepository;

import it.ntt.concessionaria.models.Dipendente;

public interface DipendenteRepository extends CrudRepository<Dipendente, Long> {
    
}
