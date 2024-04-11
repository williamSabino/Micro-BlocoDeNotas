package br.com.will.Usuario.infra.service;

import br.com.will.Usuario.domain.Usuario;
import br.com.will.Usuario.dto.ListagemUsuarioDto;
import br.com.will.Usuario.dto.UsuarioDto;
import br.com.will.Usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public ResponseEntity listar() {
        List<Usuario> listaUsuarios = repository.findAll();
        List<ListagemUsuarioDto> listaListagemUsuarioDto = listaUsuarios.stream()
                .map(u -> new ListagemUsuarioDto(u))
                .toList();
        return ResponseEntity.ok().body(listaListagemUsuarioDto);
    }

    public ResponseEntity inserirUsuario(UsuarioDto usuario) {
        Usuario user = new Usuario(usuario);
        repository.save(user);
        return ResponseEntity.created(URI.create("localhost:8084/usuarios")).build();
    }

    public ResponseEntity atualizarUsuario(Long id, UsuarioDto usuario) {
        var user = repository.getReferenceById(id);
        user.atualizar(usuario);
        return ResponseEntity.ok().body(user);
    }

    public ResponseEntity deletarUsuario(Long id) {
        if(!this.repository.existsById(id)){return ResponseEntity.badRequest().build();}
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity alterarQtdeId(Long id) {
        var user = repository.getReferenceById(id);
        user.atualizarQtdeNOtas();
        return ResponseEntity.ok().body(user);
    }
}
