package it.ntt.concessionaria.repositories;

import org.springframework.data.repository.CrudRepository;

import it.ntt.concessionaria.models.Concessionario;

public interface ConcessionarioRepository extends CrudRepository<Concessionario, Long> {
    
}
