package com.netflix.demo.repository;

import com.netflix.demo.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmeRepository extends JpaRepository<Filme,Integer> {
    public List<Filme> findFilmeByTitulo(String titulo);

    public java.util.List<Filme> findFilmeByTituloOrderByTituloAsc(String titulo);

    public List<Filme> findFilmeByTituloAndSinopse(String titulo, String sinopse);

    public List<Filme> findFilmeByTituloLike(String titulo);

    @Query("select f from Filme f where f.genero.titulo=:titulo")
    public List<Filme> getFilmeByGenero(@Param("titulo") String titulo);

}
