package br.com.will.BlocoDeNotas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notas")
public class BlocoDeNotasController {
    @GetMapping
    public ResponseEntity listarNotas(){
        return ResponseEntity.ok().body("Ola mundo Bloco de notas");
    }
}
