package br.com.will.Usuario.domain;

import br.com.will.Usuario.dto.UsuarioDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "nome", unique = false, length = 100)
    private String nome;
    @Column(name = "idade")
    private Long idade;
    @Column(name = "qtde_notas")
    private int qtdeNotas;

    public Usuario(UsuarioDto usuario) {
        this.email = usuario.email();
        this.password = usuario.password();
        this.nome = usuario.nome();
        this.idade = usuario.idade();
        this.qtdeNotas = 0;
    }

    public void atualizar(UsuarioDto usuario) {
        if(usuario.email() != null){
            this.email = usuario.email();
        }
        if(usuario.nome() != null){
            this.nome = usuario.nome();
        }
        if(usuario.idade() != null){
            this.idade = usuario.idade();
        }
    }

    public void atualizarQtdeNOtas() {
        this.qtdeNotas += 1;
    }
}
