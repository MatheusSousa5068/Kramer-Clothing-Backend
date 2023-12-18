package br.edu.ifpb.kramerclothing.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.kramerclothing.backend.model.Plan;

public interface PlanRepositoryIF extends JpaRepository<Plan, Long> {
}
