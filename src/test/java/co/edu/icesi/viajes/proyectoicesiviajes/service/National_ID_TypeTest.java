package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.National_ID_Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class National_ID_TypeTest {

    @Autowired
    private National_ID_TypeService service;

    @Test
    void findAll(){
        for(National_ID_Type n : service.findAll()){
            System.out.println(n.toString());
        }
    }

}
