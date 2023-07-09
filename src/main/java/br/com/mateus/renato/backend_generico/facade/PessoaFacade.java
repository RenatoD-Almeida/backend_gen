package br.com.mateus.renato.backend_generico.facade;

import br.com.mateus.renato.backend_generico.domain.Pessoa;
import br.com.mateus.renato.backend_generico.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PessoaFacade {

    private PessoaRepository repo;

    @Autowired
    public PessoaFacade(PessoaRepository pessoaRepository) {
        this.repo = pessoaRepository;
    }

    public List<Pessoa> findAll()
    {
        return repo.findByPessoaWithEndereco();
    }

    public List<Pessoa> findByNomeLike(String nome)
    {
        return repo.findByNomeLike(nome);
    }

}
