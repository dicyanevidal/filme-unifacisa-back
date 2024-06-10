package com.vidal.dicyane.filme_unifacisa_backend.controller;

import com.vidal.dicyane.filme_unifacisa_backend.domain.Filme;
import com.vidal.dicyane.filme_unifacisa_backend.service.FilmeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/filmes")
public class FilmeController {

    private final FilmeService filmeService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Filme> buscarPorID(@PathVariable Integer id) {
        Filme filme = filmeService.buscar(id);
        return ResponseEntity.ok().body(filme);
    }

    @GetMapping
    public ResponseEntity<List<Filme>> buscar() {
        List<Filme> lista = filmeService.buscarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping
    public ResponseEntity<Filme> inserir(@RequestBody Filme novoFilme) {
        Filme filme = filmeService.inserir(novoFilme);
        return ResponseEntity.ok().body(filme);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Filme> atualizar(@RequestBody Filme filme, @PathVariable Integer id) {
        try {
            filme.setId(id);
            filmeService.atualizar(filme);
            return ResponseEntity.ok().body(filme);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        filmeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}