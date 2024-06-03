package com.netflix.demo.service;

import com.netflix.demo.model.Boleto;
import com.netflix.demo.repository.BoletoRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class BoletoService {
    @Autowired
    private BoletoRepository repository;

    public Boleto salvar(Boleto boleto){
        boleto = repository.save(boleto);
        return boleto;
    }

    public Boleto alterar(Boleto boleto){
        if(Objects.nonNull(boleto.getId())){
            boleto = repository.save(boleto);
        }else{
            throw new NotFoundException();
        }
        return boleto;
    }

    public List<Boleto> listar(){
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

    public Boleto consultarPorId(Integer id){
        return repository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }
}