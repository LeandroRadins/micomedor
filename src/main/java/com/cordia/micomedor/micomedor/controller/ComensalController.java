package com.cordia.micomedor.micomedor.controller;

import com.cordia.micomedor.micomedor.model.Comensal;
import com.cordia.micomedor.micomedor.repository.ComensalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//TODO: Para el caso de que tenga mas de un controlador, que tengo que hacer con las anotaciones CrossOrigin y RequestMapping?

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ComensalController {

    @Autowired
    ComensalRepository comensalRepository;

    // Obtener todos los comensales
    @GetMapping("/comensales")
    public ResponseEntity<List<Comensal>> getAllComensales(@RequestParam(required = false) String nombre) {
        try {
            List<Comensal> comensales = new ArrayList<>();
            if (nombre == null) {
                comensales.addAll(comensalRepository.findAll());
            } else {
                comensales.addAll(comensalRepository.findByNombre(nombre));
            }
            if (comensales.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(comensales, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/comensales/{id}")
    public ResponseEntity<Comensal> getComensalesId(@PathVariable("id") Long id) {
        Optional<Comensal> comensalData = comensalRepository.findById(id);
        return comensalData.map(comensal -> new ResponseEntity<>(comensal, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/comensales")
    public ResponseEntity<Comensal> createComensal(@RequestBody Comensal comensal) {
        try {
            Comensal _comensal = comensalRepository.save(new Comensal(comensal.getDni(), comensal.getNombre(),
                    comensal.getApellido(), comensal.getFechaNac(), comensal.getEmail(), comensal.getTelefono(), comensal.isMarcaAsistencia()));
            return new ResponseEntity<>(_comensal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/comensales/{id}")
    public ResponseEntity<Comensal> updateComensal(@PathVariable("id") Long id, @RequestBody Comensal comensal) {
        Optional<Comensal> comensalData = comensalRepository.findById(id);
        if (comensalData.isPresent()) {
            Comensal _comensal = comensalData.get();
            _comensal.setNombre(comensal.getNombre());
            _comensal.setApellido(comensal.getApellido());
            _comensal.setDni(comensal.getDni());
            _comensal.setFechaNac(comensal.getFechaNac());
            _comensal.setEmail(comensal.getEmail());
            _comensal.setTelefono(comensal.getTelefono());
            _comensal.setComedor(comensal.getComedor());
            return new ResponseEntity<>(comensalRepository.save(_comensal), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/comensales/{id}")
    public ResponseEntity<HttpStatus> deleteComensal(@PathVariable("id") Long id) {
        try {
            comensalRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/comensales")
    public ResponseEntity<HttpStatus> deleteAllComensales() {
        try {
            comensalRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
