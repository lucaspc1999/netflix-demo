package com.netflix.demo.controller;


import com.netflix.demo.model.Filme;

import com.netflix.demo.model.MovieApi;
import com.netflix.demo.service.FilmeService;
import com.netflix.demo.service.TmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeController {
    private final TmdbService tmdbservice;
    @Autowired
    private FilmeService service;

    @PostMapping
    public ResponseEntity<Filme> salvar(@RequestBody Filme filme){
        filme = service.salvar(filme);
        return ResponseEntity.ok(filme);
    }

    @PutMapping
    public ResponseEntity<Filme> alterar(@RequestBody Filme filme){
        filme = service.alterar(filme);
        return ResponseEntity.ok(filme);
    }

    @GetMapping
    public ResponseEntity<List<Filme>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> consultar(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.consultarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable("id") Integer id) {
        if (service.excluir(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Autowired
    public FilmeController(TmdbService tmdbService) {
        this.tmdbservice = tmdbService;
    }

    @GetMapping("/popular")
    public MovieApi getPopularMovies() {
        return tmdbservice.getPopularMovies();
    }
}
