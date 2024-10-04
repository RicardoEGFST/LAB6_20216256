package com.example.lab6_20216256.repository;

import com.example.lab6_20216256.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculasRepository extends JpaRepository<Pelicula, Integer> {
}
