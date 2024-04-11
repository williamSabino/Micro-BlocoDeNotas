package br.com.will.BlocoDeNotas.repositry;

import br.com.will.BlocoDeNotas.domain.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotasRepository extends JpaRepository<Nota, Long> {
}
