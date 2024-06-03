package com.netflix.demo.service;

import com.netflix.demo.model.Favorito;
import com.netflix.demo.model.Usuario;
import com.netflix.demo.repository.FavoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritoService {

    @Autowired
    private FavoritoRepository favoritoRepository;

    public List<Favorito> getFavoritosByUsuario(Usuario usuario) {
        return favoritoRepository.findByUsuarioId(usuario.getId());
    }

    public Favorito adicionarFavorito(Favorito favorito) {
        return favoritoRepository.save(favorito);
    }

    public void removerFavorito(Integer id) {
        favoritoRepository.deleteById(id);
    }
}
