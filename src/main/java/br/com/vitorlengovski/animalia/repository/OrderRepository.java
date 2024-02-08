package br.com.vitorlengovski.animalia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vitorlengovski.animalia.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
