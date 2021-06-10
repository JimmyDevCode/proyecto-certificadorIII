package com.cortatebien.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cortatebien.app.entity.Servicio;


@Repository
public interface IServicioRepository extends JpaRepository<Servicio, Integer>{

}
