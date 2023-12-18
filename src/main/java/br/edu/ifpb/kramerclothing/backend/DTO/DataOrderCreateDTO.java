package br.edu.ifpb.kramerclothing.backend.DTO;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record DataOrderCreateDTO(
        @NotEmpty String date,
        @NotEmpty String devolutionDate,
        @NotEmpty String status,
        double price,
        @NotEmpty String kitId,
        @NotEmpty String planId,
        List<String> clothesIds,
        @NotEmpty String userId
) {
}
