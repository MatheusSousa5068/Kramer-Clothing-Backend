package br.edu.ifpb.kramerclothing.backend.DTO;

import br.edu.ifpb.kramerclothing.backend.model.Kit;
import jakarta.validation.constraints.NotEmpty;

public record DataClothingCreateDTO(
        @NotEmpty String description,
        @NotEmpty String brand,
        @NotEmpty String size,
        @NotEmpty String color,
        @NotEmpty String material,
        @NotEmpty String image_icon,
        Kit kit
) {
}
