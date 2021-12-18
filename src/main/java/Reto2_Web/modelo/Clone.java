/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2_Web.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Usuario
 */

    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Document(collection = "clone")
    public class Clone {
    @Id
    private Integer id;
    private String brand;
    private String procesor;
    private String os;
    private String description;
    private String memory;
    private String hardDrive;
    private boolean availability = true;
    private double price;
    private int quantity;
    private String photography;

}
