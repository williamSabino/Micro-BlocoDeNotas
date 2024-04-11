package br.com.will.BlocoDeNotas.controller;

import br.com.will.BlocoDeNotas.dto.ListagemNotasDto;
import br.com.will.BlocoDeNotas.infra.service.NotasService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notas")
public class BlocoDeNotasController {

    @Autowired
    private NotasService service;

    @GetMapping
    public ResponseEntity listarUsuarios(){
        return service.listar();
    }

    @PostMapping
    public ResponseEntity inserirUsuario(@RequestBody ListagemNotasDto nota){
        return service.inserirNota(nota);
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, ListagemNotasDto nota){
        return service.atualizarNota(id, nota);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        return service.deletarNota(id);
    }
}
