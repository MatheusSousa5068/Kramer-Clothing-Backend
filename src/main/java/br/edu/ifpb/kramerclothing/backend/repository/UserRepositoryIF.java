package br.edu.ifpb.kramerclothing.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.kramerclothing.backend.model.User;

public interface UserRepositoryIF extends JpaRepository<User, Long> {
	public User findByEmail(String email);
}
