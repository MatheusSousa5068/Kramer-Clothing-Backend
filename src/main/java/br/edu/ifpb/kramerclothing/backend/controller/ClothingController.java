package br.edu.ifpb.kramerclothing.backend.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.ifpb.kramerclothing.backend.DTO.DataClothingCreateDTO;
import br.edu.ifpb.kramerclothing.backend.model.Clothing;
import br.edu.ifpb.kramerclothing.backend.service.ClothingService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clothing")
@CrossOrigin(origins = "http://localhost:4200")
public class ClothingController {
    @Autowired
    private ClothingService clothingService;

    @GetMapping
    public List<Clothing> read(@RequestParam(value = "id", required = false) Long id,
    							@RequestParam(value="kitId", required=false) Long kitId) {
        if (id != null) {
            Clothing clothingSearched = this.clothingService.getClothingById(id);
            if (clothingSearched != null) {
                return Collections.singletonList(clothingSearched);
            }

            return null;
        }
        
        if(kitId != null) {
        	List<Clothing> clothingSearched = this.clothingService.getClothingByKitId(kitId);
        	
        	return clothingSearched;
        }

        return this.clothingService.readAll();
    }

    @GetMapping("/{id}")
    public Clothing getClothingById(@PathVariable("id") Long id) {
        return this.clothingService.getClothingById(id);
    }

    @PostMapping
    public Clothing create(@RequestBody @Valid DataClothingCreateDTO clothing) {
        Clothing clothingToCreate = new Clothing(
                clothing.description(),
                clothing.brand(),
                clothing.size(),
                clothing.color(),
                clothing.material(),
                clothing.kitId()
        );

        return this.clothingService.createOrUpdate(clothingToCreate);
    }

    @PutMapping
    public Clothing update(@RequestBody Clothing clothing) {
        return this.clothingService.createOrUpdate(clothing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.clothingService.delete(id);
    }
}
