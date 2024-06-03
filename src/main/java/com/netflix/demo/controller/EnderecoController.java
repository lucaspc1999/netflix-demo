package com.netflix.demo.controller;


import com.netflix.demo.model.Endereco;
import com.netflix.demo.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService service;

    @PostMapping
    public ResponseEntity<Endereco> salvar(@RequestBody Endereco endereco){
        endereco = service.salvar(endereco);
        return ResponseEntity.ok(endereco);
    }

    @PutMapping
    public ResponseEntity<Endereco> alterar(@RequestBody Endereco endereco){
        endereco = service.alterar(endereco);
        return ResponseEntity.ok(endereco);
    }

    @GetMapping("/ordenado")
    public ResponseEntity<List<Endereco>> listarEmOrdemAlfabetica(){
        return ResponseEntity.ok(service.listarEmOrdemAlfabetica());
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> consultar(@PathVariable("id") Integer id){
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
