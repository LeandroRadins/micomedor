/**
 * 
 */
package com.cordia.micomedor.micomedor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cordia.micomedor.micomedor.model.Comedor;

import java.util.*;

/**
 * @author Leandro
 *
 */
public interface ComedorRepository extends JpaRepository<Comedor, Long> {
	List<Comedor> findByNombre(String nombre);

}
