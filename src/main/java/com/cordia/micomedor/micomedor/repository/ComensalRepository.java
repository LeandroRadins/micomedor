package com.cordia.micomedor.micomedor.repository;

import com.cordia.micomedor.micomedor.model.Comedor;
import com.cordia.micomedor.micomedor.model.Comensal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComensalRepository extends JpaRepository<Comensal, Long> {
    List<Comensal> findByNombre(String nombre);
}
