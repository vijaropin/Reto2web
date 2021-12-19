/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2_Web.controlador;

import Reto2_Web.servicio.CloneService;
import Reto2_Web.modelo.Clone;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/clone")
@CrossOrigin("*")
public class CloneController {
    @Autowired
    private CloneService accessoryService;

    @GetMapping("/all")
    public List<Clone> getAll() {
        return accessoryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Clone> getClothe(@PathVariable("id") Integer id) {
        return accessoryService.getClothe(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone create(@RequestBody Clone gadget) {
        return accessoryService.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone update(@RequestBody Clone gadget) {
        return accessoryService.update(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return accessoryService.delete(id);
    }

    @GetMapping("/price/{price}")
    public List<Clone> getByPrice(@PathVariable("price") double price) {
        return accessoryService.getByPrice(price);
    }

    @GetMapping("/description/{description}")
    public List<Clone> getByDescriptionContains(@PathVariable("description") String description) {
        return accessoryService.getByDescriptionContains(description);
    }

}