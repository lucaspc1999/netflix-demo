package com.netflix.demo.service;

import com.netflix.demo.model.Planos;
import com.netflix.demo.repository.PlanosRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class PlanosService {
    @Autowired
    private PlanosRepository repository;

    public Planos salvar(Planos planos){
        planos = repository.save(planos);
        return planos;
    }

    public Planos alterar(Planos planos){
        if(Objects.nonNull(planos.getId())){
            planos = repository.save(planos);
        }else{
            throw new NotFoundException();
        }
        return planos;
    }

    public List<Planos> listar(){
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

    public Planos consultarPorId(Integer id){
        return repository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }
}
