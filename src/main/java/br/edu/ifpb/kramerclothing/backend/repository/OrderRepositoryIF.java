package br.edu.ifpb.kramerclothing.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.kramerclothing.backend.model.Order;

public interface OrderRepositoryIF extends JpaRepository<Order, Long> {
}
