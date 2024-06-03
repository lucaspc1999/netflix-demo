package com.netflix.demo.controller;

import com.netflix.demo.model.Favorito;
import com.netflix.demo.model.Usuario;
import com.netflix.demo.service.FavoritoService;
import com.netflix.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favoritos")
public class FavoritoController {

    @Autowired
    private FavoritoService favoritoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{usuarioId}")
    public List<Favorito> getFavoritos(@PathVariable Integer usuarioId) {
        Usuario usuario = usuarioService.consultarPorId(usuarioId);
        return favoritoService.getFavoritosByUsuario(usuario);
    }

    @PostMapping
    public Favorito adicionarFavorito(@RequestBody Favorito favorito) {
        return favoritoService.adicionarFavorito(favorito);
    }

    @DeleteMapping("/{id}")
    public void removerFavorito(@PathVariable Integer id) {
        favoritoService.removerFavorito(id);
    }
}
