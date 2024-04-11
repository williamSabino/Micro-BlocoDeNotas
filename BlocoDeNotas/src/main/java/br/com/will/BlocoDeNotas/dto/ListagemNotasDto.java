package br.com.will.BlocoDeNotas.dto;

import br.com.will.BlocoDeNotas.domain.Nota;

public record ListagemNotasDto(
        String titulo,
        String texto,
        Long usuarioId
) {
    public ListagemNotasDto(Nota n) {
        this(n.getTitulo(),n.getTexto(),n.getUsuarioId());
    }
}
