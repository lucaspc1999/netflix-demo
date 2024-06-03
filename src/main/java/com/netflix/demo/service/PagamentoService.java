package com.netflix.demo.service;

import com.netflix.demo.model.Pagamento;
import com.netflix.demo.repository.PagamentoRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class PagamentoService {
    @Autowired
    private PagamentoRepository repository;

    public Pagamento salvar(Pagamento pagamento){
        pagamento = repository.save(pagamento);
        return pagamento;
    }

    public Pagamento alterar(Pagamento pagamento){
        if(Objects.nonNull(pagamento.getId())){
            pagamento = repository.save(pagamento);
        }else{
            throw new NotFoundException();
        }
        return pagamento;
    }

    public List<Pagamento> listar(){
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

    public Pagamento consultarPorId(Integer id){
        return repository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }
}