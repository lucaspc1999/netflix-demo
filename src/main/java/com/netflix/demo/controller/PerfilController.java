package com.netflix.demo.controller;


import com.netflix.demo.model.Perfil;
import com.netflix.demo.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")
public class PerfilController {
    @Autowired
    private PerfilService service;

    @PostMapping
    public ResponseEntity<Perfil> salvar(@RequestBody Perfil perfil){
        perfil = service.salvar(perfil);
        return ResponseEntity.ok(perfil);
    }

    @PutMapping
    public ResponseEntity<Perfil> alterar(@RequestBody Perfil perfil){
        perfil = service.alterar(perfil);
        return ResponseEntity.ok(perfil);
    }

    @GetMapping
    public ResponseEntity<List<Perfil>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perfil> consultar(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.consultarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable("id") Integer id){
        if(service.excluir(id)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
