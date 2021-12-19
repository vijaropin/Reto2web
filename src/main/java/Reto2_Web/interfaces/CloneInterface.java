/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto2_Web.interfaces;

import Reto2_Web.modelo.Clone;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 *
 * @author Usuario
 */
public interface CloneInterface extends MongoRepository<Clone, Integer>{
      public List<Clone> findByPrice(double price);
      public List<Clone> findByDescriptionContainsIgnoreCase(String description);
    
}
