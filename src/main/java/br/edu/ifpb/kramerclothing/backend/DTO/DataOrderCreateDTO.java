package br.edu.ifpb.kramerclothing.backend.DTO;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record DataOrderCreateDTO(
        String date,
        String devolutionDate,
        String status,
        double price,
        String kitId,
        String planId,
        List<String> clothesIds,
        String userId
) {
}
