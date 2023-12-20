package br.edu.ifpb.kramerclothing.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.kramerclothing.backend.model.Kit;
import br.edu.ifpb.kramerclothing.backend.repository.KitRepositoryIF;
import jakarta.transaction.Transactional;

@Service
public class KitService {

    @Autowired
    private KitRepositoryIF kitRepository;

    public List<Kit> readAll() {
        return this.kitRepository.findAll();
    }

    public Kit getKitById(Long id) {
        return this.kitRepository.findById(id).orElse(null);
    }

    @Transactional
    public Kit createOrUpdate(Kit kit) {
        Kit kitSearched = this.kitRepository.save(kit);
        kit.setName(kit.getName());
        return kitSearched;
    }

    public void delete(Long id) {
        this.kitRepository.deleteById(id);
    }
}
