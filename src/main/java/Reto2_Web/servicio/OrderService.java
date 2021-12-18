/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2_Web.servicio;

import Reto2_Web.modelo.Order;
import Reto2_Web.repositorio.OrderRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepositorio orderRepositorio;
    
    public List<Order> getAll(){
        return orderRepositorio.getAll();
    }
    public Optional<Order> getOrder(Integer id){
        return orderRepositorio.getOrder(id);
    }
    public Order save(Order order){
        if (order.getId() == null){
            return order;
        } else {
            return orderRepositorio.create(order);
        }
    }
    public Order update(Order order){
        if (order.getId() != null){
            Optional<Order> dbOrder = orderRepositorio.getOrder(order.getId());
            if (!dbOrder.isEmpty()) {
                if (order.getId() != null) {
                    dbOrder.get().setId(order.getId());
                }

                if (order.getRegisterDay() != null) {
                    dbOrder.get().setRegisterDay(order.getRegisterDay());
                }

                if (order.getStatus() != null) {
                    dbOrder.get().setStatus(order.getStatus());
                }

                if (order.getSalesMan() != null) {
                    dbOrder.get().setSalesMan(order.getSalesMan());
                }

                if (order.getProducts() != null) {
                    dbOrder.get().setProducts(order.getProducts());
                }

                if (order.getQuantities() != null) {
                    dbOrder.get().setQuantities(order.getQuantities());
                }
                orderRepositorio.update(dbOrder.get());
                return dbOrder.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    public boolean delete(int id){
        return getOrder(id).map(order -> {
            orderRepositorio.delete(order);
            return true;
        }).orElse(false);
    }

    public List<Order> getOrderByZone(String zone){
        return orderRepositorio.getOrderByZone(zone);
    }
   
}
