package it.ntt.concessionaria.repositories;

import org.springframework.data.repository.CrudRepository;

import it.ntt.concessionaria.models.Auto;

public interface AutoRepository extends CrudRepository<Auto, Long> {
    
}
