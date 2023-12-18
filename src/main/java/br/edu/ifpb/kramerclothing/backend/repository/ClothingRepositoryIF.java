package br.edu.ifpb.kramerclothing.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.kramerclothing.backend.model.Clothing;

public interface ClothingRepositoryIF extends JpaRepository<Clothing, Long> {
}
