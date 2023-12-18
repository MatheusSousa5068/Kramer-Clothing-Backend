package br.edu.ifpb.kramerclothing.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.kramerclothing.backend.model.Clothing;
import br.edu.ifpb.kramerclothing.backend.repository.ClothingRepositoryIF;
import jakarta.transaction.Transactional;

@Service
public class ClothingService {

    @Autowired
    private ClothingRepositoryIF clothingRepository;

    public List<Clothing> readAll() {
        return this.clothingRepository.findAll();
    }

    public Clothing getClothingById(Long id) {
        return this.clothingRepository.findById(id).orElse(null);
    }

    @Transactional
    public Clothing createOrUpdate(Clothing clothing) {
        Clothing clothingSearched = this.clothingRepository.save(clothing);

        // Modificação fictícia para exemplificar
        clothing.setDescription(clothing.getDescription() + " - alterado");
        return clothingSearched;
    }

    public void delete(Long id) {
        this.clothingRepository.deleteById(id);
    }
}