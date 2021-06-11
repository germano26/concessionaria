package it.ntt.concessionaria.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.ntt.concessionaria.models.Concessionario;

public interface ConcessionarioRepository extends CrudRepository<Concessionario, Long> {

    // SELECT COUNT(DISTINCT regioni) FROM concessionario 
    // @Query("SELECT COUNT(DISTINCT(c.regione)) FROM Concessionario c")
    @Query("SELECT COUNT(c) FROM Concessionario c")
    Integer countRegion();
    
}
