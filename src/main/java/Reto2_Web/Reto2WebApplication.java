//modelo
//interface
//repositorio
//servicio
//controlador


package Reto2_Web;

import Reto2_Web.interfaces.CloneInterface;
import Reto2_Web.interfaces.OrderInterface;
import Reto2_Web.interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class Reto2WebApplication implements CommandLineRunner {
    @Autowired
    private CloneInterface cloneInterface;
    @Autowired
    private UserInterface userInterface;
    @Autowired
    private OrderInterface orderInterface;
    
    public static void main(String[] args) {
        SpringApplication.run(Reto2WebApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        cloneInterface.deleteAll();
        userInterface.deleteAll();
        orderInterface.deleteAll();
    }
}

