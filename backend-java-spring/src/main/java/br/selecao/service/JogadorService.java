package br.selecao.service;

import br.selecao.model.Jogador;

import java.util.List;
import java.util.Optional;

public interface JogadorService {

    public List<Jogador> findAll();
    public Optional<Jogador> findById(long id);
    public Jogador create(Jogador newUsuario);
    public Jogador update(Jogador updatedJogador, long id);
    public void delete(long id);
}