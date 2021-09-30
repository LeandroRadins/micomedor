package com.cordia.micomedor.micomedor.controller;

import com.cordia.micomedor.micomedor.model.Comensal;
import com.cordia.micomedor.micomedor.repository.ComensalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
}
