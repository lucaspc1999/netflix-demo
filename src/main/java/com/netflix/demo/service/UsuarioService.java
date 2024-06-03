package com.netflix.demo.service;

import com.netflix.demo.model.Usuario;
import com.netflix.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
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

    public Usuario atualizar(Usuario usuario) {

        Usuario existingUsuario = repository.findById(usuario.getId()).orElse(null);
        if (existingUsuario != null) {
            existingUsuario.setNome(usuario.getNome());
            existingUsuario.setNumero(usuario.getNumero());
            existingUsuario.setCpf(usuario.getCpf());
            existingUsuario.setLogin(usuario.getLogin());
            existingUsuario.setEmail(usuario.getEmail());
            existingUsuario.setData_nasc(usuario.getData_nasc());
            existingUsuario.setSenha(usuario.getSenha());
            existingUsuario.setEndereco(usuario.getEndereco());
            return repository.save(existingUsuario);
        } else {
            throw new RuntimeException("Usuário não encontrado com ID: " + usuario.getId());
        }
    }
}
