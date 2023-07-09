package br.com.mateus.renato.backend_generico.controller;

import br.com.mateus.renato.backend_generico.domain.Pessoa;
import br.com.mateus.renato.backend_generico.facade.PessoaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private PessoaFacade facade;

    @Autowired
    public PessoaController(PessoaFacade pessoaFacade) {
        this.facade = pessoaFacade;
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> getAll()
    {
        return ResponseEntity.status(HttpStatus.OK).body(facade.findAll());
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Object> getById(@PathVariable(value = "nome") String nome){
        List<Pessoa> byNomeLike = facade.findByNomeLike(nome);
        if (byNomeLike.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList());
        }

        return ResponseEntity.status(HttpStatus.OK).body(byNomeLike);
    }
}
