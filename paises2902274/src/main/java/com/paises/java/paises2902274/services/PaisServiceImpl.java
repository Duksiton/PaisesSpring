package com.paises.java.paises2902274.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paises.java.paises2902274.entities.pais;
import com.paises.java.paises2902274.repositories.PaisRepository;

@Service
public class PaisServiceImpl implements IPaisService{

    //Referencia al PaísRepository
    @Autowired
    private PaisRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<pais> findAll() {
        return (List<pais>) repository.findAll();

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<pais> findById(Long id) {
        return repository.findById(id);

    }

    @Override
    @Transactional
    public pais save(pais Pais) {
        return repository.save(Pais);

    }

    @Override
    @Transactional
    public Optional<pais> delete(Long id) {
        //1. Seleccionar el país por id
        Optional<pais> paisDb = repository.findById(id);
        paisDb.ifPresent(p ->{
            //2. si existe el país, borrarlo de la base de datos
            repository.delete(p);
        });
        return paisDb;
    }
}
