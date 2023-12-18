package br.edu.ifpb.kramerclothing.backend.DTO;

import jakarta.validation.constraints.NotEmpty;

public record DataUserCreateDTO(
    @NotEmpty String nome,
    @NotEmpty String CPF,
    @NotEmpty Integer idade
) {};