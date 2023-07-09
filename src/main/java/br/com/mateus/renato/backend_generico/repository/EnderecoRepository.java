package br.com.mateus.renato.backend_generico.repository;

import br.com.mateus.renato.backend_generico.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
