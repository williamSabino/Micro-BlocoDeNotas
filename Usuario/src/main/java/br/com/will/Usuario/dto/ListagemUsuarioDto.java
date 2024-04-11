package br.com.will.Usuario.dto;

import br.com.will.Usuario.domain.Usuario;

public record ListagemUsuarioDto(
        String email,
        String nome,
        Long idade,
        int qtdeNotas
) {
    public ListagemUsuarioDto(Usuario u) {
        this(u.getEmail(), u.getNome(), u.getIdade(), u.getQtdeNotas());
    }
}
