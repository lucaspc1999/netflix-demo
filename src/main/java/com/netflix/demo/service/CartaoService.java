package com.netflix.demo.service;


import com.netflix.demo.model.Cartao;
import com.netflix.demo.repository.CartaoRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class CartaoService {

    @Autowired
    private CartaoRepository repository;

    public Cartao salvar(Cartao cartao) {
        cartao = repository.save(cartao);
        return cartao;
    }

    public Cartao alterar(Cartao cartao) {
        if (Objects.nonNull(cartao.getId())) {
            cartao = repository.save(cartao);
        } else {
            throw new NotFoundException();
        }
        return cartao;
    }

    public List<Cartao> listar() {
        return repository.findAll();
    }

    public Boolean excluir(Integer id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            log.info("Erro ao realizar Exclusão : {}", e);
            return false;

        }
        return true;
    }

    public Cartao consultarPorId(Integer id) {
        return repository
                .findById(id)
                .orElseThrow(NotFoundException::new);

    }
}