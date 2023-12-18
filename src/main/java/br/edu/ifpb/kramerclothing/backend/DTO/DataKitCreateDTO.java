package br.edu.ifpb.kramerclothing.backend.DTO;

import jakarta.validation.constraints.NotEmpty;

public record DataKitCreateDTO(
        @NotEmpty String name,
        double factor
) {
}
