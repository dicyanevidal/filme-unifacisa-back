package com.vidal.dicyane.filme_unifacisa_backend.service;

import com.vidal.dicyane.filme_unifacisa_backend.domain.Filme;
import com.vidal.dicyane.filme_unifacisa_backend.repository.FilmeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public List<Filme> buscarTodos() {
        return filmeRepository.findAll();
    }

    public Filme inserir(Filme filme) {
        filmeRepository.save(filme);
        return filme;
    }

    public Filme atualizar(Filme filme) {
        Filme novoObjeto = buscar(filme.getId());
        atualizarObjeto(novoObjeto, filme);
        return filmeRepository.save(novoObjeto);
    }

    public void deletar(Integer id) {
        try {
            Filme filme = buscar(id);
            filmeRepository.delete(filme);
        } catch (RuntimeException e) {
            throw new RuntimeException("Não existem filmes relacionados");
        }
    }

    public Filme buscar(Integer id) {
        Filme objeto = filmeRepository.findById(id).get();

        if (objeto == null) {
            throw new RuntimeException("Objeto não encontrado! Id: " + id + ", Tipo: " + Filme.class.getName());
        }

        return objeto;
    }

    private void atualizarObjeto(Filme novoObjeto, Filme objeto) {
        novoObjeto.setTitulo(objeto.getTitulo());
        novoObjeto.setDiretor(objeto.getDiretor());
        novoObjeto.setGenero(objeto.getGenero());
        novoObjeto.setDuracao(objeto.getDuracao());
        novoObjeto.setAnoLancamento(objeto.getAnoLancamento());
    }
}
