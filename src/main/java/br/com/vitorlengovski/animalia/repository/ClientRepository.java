
package br.com.vitorlengovski.animalia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vitorlengovski.animalia.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	public Client findByCpf(String cpf);
}
