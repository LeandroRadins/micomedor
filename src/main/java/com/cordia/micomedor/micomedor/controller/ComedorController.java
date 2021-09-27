
package com.cordia.micomedor.micomedor.controller;

import com.cordia.micomedor.micomedor.model.Comedor;
import com.cordia.micomedor.micomedor.repository.ComedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Leandro
 *
 */
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ComedorController {

    @Autowired
    ComedorRepository comedorRepository;

    // Obtener todos los comedores
    @GetMapping("/comedores")
    public ResponseEntity<List<Comedor>> getComedores(@RequestParam(required = false) String nombre) {
        try {
            List<Comedor> comedores = new ArrayList<Comedor>();
            if (nombre == null) {
                comedorRepository.findAll().forEach(comedores::add);
            } else {
                comedorRepository.findByNombre(nombre).forEach(comedores::add);
            }
            if (comedores.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(comedores, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener un comedor por id
    @GetMapping("/comedores/{id}")
    public ResponseEntity<Comedor> getComedoresId(@PathVariable("id") Long id) {
        Optional<Comedor> comedorData = comedorRepository.findById(id);

        if (comedorData.isPresent()) {
            return new ResponseEntity<>(comedorData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear un comedor
    @PostMapping("/comedores")
    public ResponseEntity<Comedor> createComedor(@RequestBody Comedor comedor) {
        try {
            Comedor _comedor = comedorRepository.save(new Comedor(comedor.getNombre(), comedor.getDireccion(),
                    comedor.getCorreo(), comedor.getTelefono()));
            return new ResponseEntity<>(_comedor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/comedores/{id}")
    public ResponseEntity<Comedor> updateComedor(@PathVariable("id") long id, @RequestBody Comedor comedor) {
        Optional<Comedor> comedorData = comedorRepository.findById(id);

        if (comedorData.isPresent()) {
            Comedor _comedor = comedorData.get();
            _comedor.setNombre(comedor.getNombre());
            _comedor.setDireccion(comedor.getDireccion());
            _comedor.setCorreo(comedor.getCorreo());
            _comedor.setTelefono(comedor.getTelefono());
            return new ResponseEntity<>(comedorRepository.save(_comedor), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/comedores/{id}")
    public ResponseEntity<HttpStatus> deleteComedor(@PathVariable("id") long id) {
        try {
            comedorRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/comedores")
    public ResponseEntity<HttpStatus> deleteAllComedores() {
        try {
            comedorRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
