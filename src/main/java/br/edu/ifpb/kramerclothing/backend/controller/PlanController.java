package br.edu.ifpb.kramerclothing.backend.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.ifpb.kramerclothing.backend.DTO.DataPlanCreateDTO;
import br.edu.ifpb.kramerclothing.backend.model.Plan;
import br.edu.ifpb.kramerclothing.backend.service.PlanService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/plans")
public class PlanController {
    @Autowired
    private PlanService planService;

    @GetMapping
    public List<Plan> read(@RequestParam(value = "id", required = false) Long id) {
        if (id != null) {
            Plan planSearched = this.planService.getPlanById(id);
            if (planSearched != null) {
                return Collections.singletonList(planSearched);
            }

            return null;
        }

        return this.planService.readAll();
    }

    @GetMapping("/{id}")
    public Plan getPlanById(@PathVariable("id") Long id) {
        return this.planService.getPlanById(id);
    }

    @PostMapping
    public Plan create(@RequestBody @Valid DataPlanCreateDTO plan) {
        Plan planToCreate = new Plan(
                plan.duration(),
                plan.basePrice(),
                plan.numOfClothes()
        );

        return this.planService.createOrUpdate(planToCreate);
    }

    @PutMapping
    public Plan update(@RequestBody Plan plan) {
        return this.planService.createOrUpdate(plan);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.planService.delete(id);
    }
}
