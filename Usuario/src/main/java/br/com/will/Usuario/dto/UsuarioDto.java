package br.com.will.Usuario.dto;

public record UsuarioDto(
        String email,
        String password,
        String nome,
        Long idade
) {
}
