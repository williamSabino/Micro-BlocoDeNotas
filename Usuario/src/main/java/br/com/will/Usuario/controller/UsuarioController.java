package br.com.will.Usuario.controller;

import br.com.will.Usuario.dto.UsuarioDto;
import br.com.will.Usuario.infra.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity listarUsuarios(){
        return service.listar();
    }

    @PostMapping
    public ResponseEntity inserirUsuario(@RequestBody UsuarioDto usuario){
        return service.inserirUsuario(usuario);
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, UsuarioDto usuario){
        return service.atualizarUsuario(id, usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        return service.deletarUsuario(id);
    }

    @PutMapping("/qtdeNotas/{id}")
    @Transactional
    public ResponseEntity alterarQtdeId(@PathVariable Long id){
        return service.alterarQtdeId(id);
    }

    @PutMapping("/qtdeNotasMenos/{id}")
    @Transactional
    public ResponseEntity subtrairQtdeNotas(@PathVariable Long id){
        return service.subtrairQtdeNotas(id);
    }


}
