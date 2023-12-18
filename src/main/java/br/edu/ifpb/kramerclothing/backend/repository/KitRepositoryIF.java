package br.edu.ifpb.kramerclothing.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.kramerclothing.backend.model.Kit;

public interface KitRepositoryIF extends JpaRepository<Kit, Long> {
}
