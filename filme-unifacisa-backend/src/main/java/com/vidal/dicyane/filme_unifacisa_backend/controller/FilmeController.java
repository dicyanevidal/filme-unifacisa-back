package com.vidal.dicyane.filme_unifacisa_backend.controller;

import com.vidal.dicyane.filme_unifacisa_backend.domain.Filme;
import com.vidal.dicyane.filme_unifacisa_backend.repository.FilmeRepository;
import com.vidal.dicyane.filme_unifacisa_backend.service.FilmeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value="/filmes")
@RequiredArgsConstructor
public class FilmeController {

    private final FilmeService filmeService;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Filme> buscarPorID(@PathVariable Integer id) {
        Filme filme = filmeService.buscar(id);
        return ResponseEntity.ok().body(filme);
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Filme>> buscar() {
        List<Filme> lista = filmeService.buscarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Filme> inserir(@RequestBody Filme novoFilme) {
        Filme filme = filmeService.inserir(novoFilme);
        return ResponseEntity.ok().body(filme);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Filme> atualizar(@RequestBody Filme filme, @PathVariable Integer id) {
        try {
            filme.setId(id);
            filmeService.atualizar(filme);
            return ResponseEntity.ok().body(filme);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        filmeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
