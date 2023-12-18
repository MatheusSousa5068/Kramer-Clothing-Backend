package br.edu.ifpb.kramerclothing.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.kramerclothing.backend.model.Plan;
import br.edu.ifpb.kramerclothing.backend.repository.PlanRepositoryIF;
import jakarta.transaction.Transactional;

@Service
public class PlanService {

    @Autowired
    private PlanRepositoryIF planRepository;

    public List<Plan> readAll() {
        return this.planRepository.findAll();
    }

    public Plan getPlanById(Long id) {
        return this.planRepository.findById(id).orElse(null);
    }

    @Transactional
    public Plan createOrUpdate(Plan plan) {
        Plan planSearched = this.planRepository.save(plan);

        // Modificação fictícia para exemplificar
        plan.setDuration(plan.getDuration() + 1);
        return planSearched;
    }

    public void delete(Long id) {
        this.planRepository.deleteById(id);
    }
}
