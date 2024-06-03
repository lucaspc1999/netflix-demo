package com.netflix.demo.service;

import com.netflix.demo.model.Perfil;
import com.netflix.demo.repository.PerfilRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class PerfilService {
    @Autowired
    private PerfilRepository repository;

    public Perfil salvar(Perfil perfil){
        perfil = repository.save(perfil);
        return perfil;
    }

    public Perfil alterar(Perfil perfil){
        if(Objects.nonNull(perfil.getId())){
            perfil = repository.save(perfil);
        }else{
            throw new NotFoundException();
        }
        return perfil;
    }

    public List<Perfil> listar(){
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

    public Perfil consultarPorId(Integer id){
        return repository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }
}

