package br.edu.ifpb.kramerclothing.backend.DTO;

import jakarta.validation.constraints.NotEmpty;

public record DataUserCreateDTO(
    @NotEmpty String name,
    @NotEmpty String email,
    @NotEmpty String password
) {};