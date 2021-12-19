/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2_Web.repositorio;

import Reto2_Web.interfaces.CloneInterface;
import Reto2_Web.modelo.Clone;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Usuario
 */
@Repository
public class CloneRepositorio {
    @Autowired
    private CloneInterface repository;

    public List<Clone> getAll() {
        return repository.findAll();
    }

    public Optional<Clone> getClothe(Integer id) {
        return repository.findById(id);

    }

    public Clone create(Clone clothe) {
        return repository.save(clothe);
    }

    public void update(Clone clothe) {
        repository.save(clothe);
    }

    public void delete(Clone clothe) {
        repository.delete(clothe);
    }

    public List<Clone> getByPrice(double price) {
        return repository.findByPrice(price);
    }

    public List<Clone> getByDescriptionContains(String description) {
        return repository.findByDescriptionContainsIgnoreCase(description);
    }

}

