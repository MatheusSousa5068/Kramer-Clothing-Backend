package br.edu.ifpb.kramerclothing.backend.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.ifpb.kramerclothing.backend.DTO.DataKitCreateDTO;
import br.edu.ifpb.kramerclothing.backend.model.Kit;
import br.edu.ifpb.kramerclothing.backend.service.KitService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/kits")
public class KitController {
    @Autowired
    private KitService kitService;

    @GetMapping
    public List<Kit> read(@RequestParam(value = "id", required = false) Long id) {
        if (id != null) {
            Kit kitSearched = this.kitService.getKitById(id);
            if (kitSearched != null) {
                return Collections.singletonList(kitSearched);
            }

            return null;
        }

        return this.kitService.readAll();
    }

    @GetMapping("/{id}")
    public Kit getKitById(@PathVariable("id") Long id) {
        return this.kitService.getKitById(id);
    }

    @PostMapping
    public Kit create(@RequestBody @Valid DataKitCreateDTO kit) {
        Kit kitToCreate = new Kit(
                kit.name(),
                kit.factor()
        );

        return this.kitService.createOrUpdate(kitToCreate);
    }

    @PutMapping
    public Kit update(@RequestBody Kit kit) {
        return this.kitService.createOrUpdate(kit);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.kitService.delete(id);
    }
}
