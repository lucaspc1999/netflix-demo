package com.netflix.demo.service;

import com.netflix.demo.model.Endereco;
import com.netflix.demo.repository.EnderecoRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EnderecoService {
    @Autowired
    private EnderecoRepository repository;

    public Endereco salvar(Endereco endereco){
        endereco = repository.save(endereco);
        return endereco;
    }

    public Endereco alterar(Endereco endereco){
        if(Objects.nonNull(endereco.getId())){
            endereco = repository.save(endereco);
        }else{
            throw new NotFoundException();
        }
        return endereco;
    }

    public List<Endereco> listar(){
        return repository.findAll();
    }

    public Boolean excluir(Integer id){
        try {
            repository.deleteById(id);
        }catch (Exception e ){
            log.info("Erro ao realizar Exclusão : {}", e);
            return false;

        }
        return true;
    }

    public Endereco consultarPorId(Integer id){
        return repository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }

    public List<Endereco> listarEmOrdemAlfabetica() {
        List<Endereco> enderecos = listar();
        return enderecos.stream()
                .sorted((e1, e2) -> e1.getEndereco().compareToIgnoreCase(e2.getEndereco()))
                .collect(Collectors.toList());
    }
}