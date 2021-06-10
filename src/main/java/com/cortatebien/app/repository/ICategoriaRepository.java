package com.cortatebien.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cortatebien.app.entity.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {

}
