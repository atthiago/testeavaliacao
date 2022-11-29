package br.selecao.controller;

import br.selecao.model.Jogador;
import br.selecao.service.JogadorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class JogadorController {

    @Autowired
    JogadorServiceImpl jogadorService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/selecao")
    public List<Jogador> findAll(){
        return jogadorService.findAll();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/selecao/verJogador/{id}")
    public Optional<Jogador> findById(@PathVariable long id){
        return jogadorService.findById(id);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, path = "/selecao/convocarJogador")
    public Jogador create(@RequestBody Jogador jogador){
        return jogadorService.create(jogador);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, path = "/selecao/atualizarJogador/{id}")
    public Jogador update(@RequestBody Jogador jogador, @PathVariable long id){
        return jogadorService.update(jogador, id);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, path = "/selecao/excluirJogador/{id}")
    public void delete(@PathVariable long id){
        jogadorService.delete(id);
    }
}