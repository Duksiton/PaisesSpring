package com.paises.java.paises2902274.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paises.java.paises2902274.entities.pais;
import com.paises.java.paises2902274.services.PaisServiceImpl;

@RestController

public class PaisController {
    @Autowired
    private PaisServiceImpl service;

    @GetMapping("/api/Pais")
    public List<pais> mostrarPais() {
        // buscar todos los paises en bd
        // usando el service
        return service.findAll();

    }

    @GetMapping("/api/Pais/{id}")
    public pais mostrarPaisPorId(@PathVariable Long id) {
        Optional<pais> optPais = service.findById(id);
        return optPais.get();
        // busca todo lo que coincida con el id
    }

    // ruta para grabar un pais en la base de datos
    @PostMapping("/api/Pais")

    public pais crearPais(@RequestBody pais paisGrabar) {
        pais paisNew = service.save(paisGrabar);
        return paisNew;
    }

    // ruta para actualizar un pais por id en BD
    @PutMapping("/api/Pais/{id}")
    public pais actualizarPais(@PathVariable Long id, @RequestBody pais paisUpd) {
        pais p = service.findById(id).get();
        p.setCapital(paisUpd.getCapital());
        p.setNombre(paisUpd.getNombre());

        // grabar cambios

        return service.save(p);
    }

    @DeleteMapping("/api/Pais/{id}")
    public pais borrarPais(@PathVariable Long id) {
        return service.delete(id).get();
    }
}