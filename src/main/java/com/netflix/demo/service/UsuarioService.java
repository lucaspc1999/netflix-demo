package com.netflix.demo.service;

import com.netflix.demo.model.Usuario;
import com.netflix.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    private UsuarioRepository repository;
    public Usuario salvar(Usuario usuario){
        return repository.save(usuario);
    }

    public List<Usuario> Listar(){
        return repository.findAll();
    }

    public Usuario consultarPorId(Integer id){
        return repository.findById(id).get();
    }

    public void  excluir(int id){
        repository.deleteById(id);
    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
