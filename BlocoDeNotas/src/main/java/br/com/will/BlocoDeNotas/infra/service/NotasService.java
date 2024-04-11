package br.com.will.BlocoDeNotas.infra.service;

import br.com.will.BlocoDeNotas.clients.UsuarioClient;
import br.com.will.BlocoDeNotas.domain.Nota;
import br.com.will.BlocoDeNotas.dto.ListagemNotasDto;
import br.com.will.BlocoDeNotas.repositry.NotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
public class NotasService {
    @Autowired
    private NotasRepository repository;
    @Autowired
    private UsuarioClient client;

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
        client.adicionarQtdeNotas(nota.getUsuarioId());
        return ResponseEntity.created(URI.create("localhost:8084/notas")).build();
    }

    public ResponseEntity atualizarNota(Long id, ListagemNotasDto notaDto) {
        var nota = repository.getReferenceById(id);
        nota.atualizar(notaDto);
        return ResponseEntity.ok().body(nota);
    }

    public ResponseEntity deletarNota(Long id) {
        var nota = repository.findById(id);
        if(nota.isEmpty()){return ResponseEntity.badRequest().build();}
        repository.deleteById(id);
        client.subtrairQtdeNotas(nota.get().getUsuarioId());
        return ResponseEntity.ok().build();
    }
}
