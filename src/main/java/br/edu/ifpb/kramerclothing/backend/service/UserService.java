package br.edu.ifpb.kramerclothing.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.kramerclothing.backend.model.User;
import br.edu.ifpb.kramerclothing.backend.repository.UserRepositoryIF;
import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepositoryIF userRepository;

    public List<User> readAll() {
        return this.userRepository.findAll();
    }

    public User getUserById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }
    
    public User getUserByEmail(String email) {
    	return this.userRepository.findByEmail(email);
    }

    @Transactional
    public User createOrUpdate(User user) {
        User userSearched = this.userRepository.save(user);
        return userSearched;
    }

    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }
}