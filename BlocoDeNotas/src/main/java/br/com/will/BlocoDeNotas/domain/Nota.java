package br.com.will.BlocoDeNotas.domain;

import br.com.will.BlocoDeNotas.dto.ListagemNotasDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "notas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo", length = 100, unique = true)
    private String titulo;
    @Column(name = "texto")
    private String texto;
    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    public Nota(ListagemNotasDto nota) {
        this.titulo = nota.titulo();
        this.texto = nota.texto();
        this.usuarioId = nota.usuarioId();
    }

    public void atualizar(ListagemNotasDto notaDto) {
        if(notaDto.titulo() != null){
            this.titulo = notaDto.titulo();
        }
        if(notaDto.texto() != null){
            this.texto = notaDto.texto();
        }
    }
}
