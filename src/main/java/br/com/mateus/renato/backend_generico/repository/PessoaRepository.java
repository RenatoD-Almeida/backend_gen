package br.com.mateus.renato.backend_generico.repository;

import br.com.mateus.renato.backend_generico.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("SELECT p FROM Pessoa p JOIN p.endereco e")
    List<Pessoa> findByPessoaWithEndereco();

    @Query("SELECT p FROM Pessoa p JOIN p.endereco e WHERE p.nome LIKE %:nome%")
    List<Pessoa> findByNomeLike(@Param("nome") String nome);
}
