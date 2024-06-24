package com.paises.java.paises2902274.services;

import java.util.List;
import java.util.Optional;

import com.paises.java.paises2902274.entities.pais;

public interface IPaisService {

    //metodos de la CRUD que se podrán usar en la aplicación

    List<pais> findAll();
    //seleccionar un pais por el id
    Optional<pais> findById(Long id);
    //guardar un país por el id (Nuevo o para actualizar)
    pais save(pais Pais);
    //delete del país
    Optional<pais>delete(Long id);


}
