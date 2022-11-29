package br.selecao.service;

import br.selecao.model.Jogador;
import br.selecao.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorServiceImpl implements JogadorService{
    @Autowired
    JogadorRepository jogadorRepository;

    @Override
    public List<Jogador> findAll() {
        return jogadorRepository.findAll();
    }

    @Override
    public Optional<Jogador> findById(long id) {
        return jogadorRepository.findById(id);
    }

    @Override
    public Jogador create(Jogador newJogador) {
        return jogadorRepository.save(newJogador);
    }

    @Override
    public Jogador update(Jogador updatedJogador, long id) {
        return jogadorRepository.findById(id)
                .map(u -> {
                    u.setNome(updatedJogador.getNome());
                    u.setSobrenome(updatedJogador.getSobrenome());
                    u.setId(id);
                    u.setNumero(updatedJogador.getNumero());
                    u.setIdade(updatedJogador.getIdade());
                    return jogadorRepository.save(u);
                })
                .orElseGet(() ->{
                    updatedJogador.setId(id);
                    return jogadorRepository.save(updatedJogador);
                });
    }

    @Override
    public void delete(long id) {
        jogadorRepository.deleteById(id);
    }
}