package com.netflix.demo.repository;

import com.netflix.demo.model.Planos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanosRepository extends JpaRepository<Planos,Integer> {
}
