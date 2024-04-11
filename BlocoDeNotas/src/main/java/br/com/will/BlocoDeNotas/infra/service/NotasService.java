package br.com.will.BlocoDeNotas.infra.service;

import br.com.will.BlocoDeNotas.repositry.NotasRepository;
import br.com.will.BlocoDeNotas.domain.Nota;
import br.com.will.BlocoDeNotas.dto.ListagemNotasDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
public class NotasService {
    @Autowired
    private NotasRepository repository;

    public ResponseEntity listar() {
        List<Nota> listaUsuarios = repository.findAll();
        List<ListagemNotasDto> listaListagemNotaDto = listaUsuarios.stream()
                .map(n -> new ListagemNotasDto(n))
                .toList();
        return ResponseEntity.ok().body(listaListagemNotaDto);
    }

    public ResponseEntity inserirNota(ListagemNotasDto notaDto) {
        Nota nota = new Nota(notaDto);
        repository.save(nota);
        return ResponseEntity.created(URI.create("localhost:8084/notas")).build();
    }

    public ResponseEntity atualizarNota(Long id, ListagemNotasDto notaDto) {
        var nota = repository.getReferenceById(id);
        nota.atualizar(notaDto);
        return ResponseEntity.ok().body(nota);
    }

    public ResponseEntity deletarNota(Long id) {
        if(!this.repository.existsById(id)){return ResponseEntity.badRequest().build();}
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
