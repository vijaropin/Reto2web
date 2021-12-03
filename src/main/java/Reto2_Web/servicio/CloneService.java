/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2_Web.servicio;


import Reto2_Web.modelo.Clone;
import Reto2_Web.repositorio.CloneRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class CloneService {
     @Autowired
    private CloneRepositorio clotheRepository;

    public List<Clone> getAll() {
        return clotheRepository.getAll();
    }

   public Optional<Clone> getClothe(Integer id) {
        return clotheRepository.getClothe(id);
    }

    public Clone create(Clone accesory) {
        if (accesory.getId() == null) {
            return accesory;
        } else {
            return clotheRepository.create(accesory);
        }
    }

    public Clone update(Clone accesory) {

        if (accesory.getId() != null) {
            Optional<Clone> accesoryDb = clotheRepository.getClothe((Integer) accesory.getId());
            if (!accesoryDb.isEmpty()) {
                
                if (accesory.getBrand()!= null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }
                
                if (accesory.getProcesor() != null) {
                    accesoryDb.get().setProcesor(accesory.getProcesor());
                }
                
                if (accesory.getOs() != null) {
                    accesoryDb.get().setOs(accesory.getOs());
                }
                                
                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getMemory() != null) {
                    accesoryDb.get().setMemory(accesory.getMemory());
                }
                if (accesory.getHardDrive() != null) {
                    accesoryDb.get().setHardDrive(accesory.getHardDrive());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                clotheRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(Integer id) {
        Boolean aBoolean = getClothe(id).map(accesory -> {
            clotheRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
}