package br.com.vitorlengovski.animalia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vitorlengovski.animalia.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long>{

    	public List<Pet> findByClientId(Long id);

}
