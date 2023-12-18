package br.edu.ifpb.kramerclothing.backend.DTO;

import jakarta.validation.constraints.NotEmpty;

public record DataPlanCreateDTO(
        @NotEmpty int duration,
        @NotEmpty double basePrice,
        @NotEmpty int numOfClothes) {
}
