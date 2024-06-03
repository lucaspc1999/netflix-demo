package com.netflix.demo.service;

import com.netflix.demo.model.Series;
import com.netflix.demo.repository.SeriesRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class SeriesService {
    @Autowired
    private SeriesRepository repository;

    public Series salvar(Series series) {
        series = repository.save(series);
        return series;
    }

    public Series alterar(Series series) {
        if (Objects.nonNull(series.getId())) {
            series = repository.save(series);
        } else {
            throw new NotFoundException();
        }
        return series;
    }

    public List<Series> listar() {
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

    public Series consultarPorId(Integer id) {
        return repository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }
}