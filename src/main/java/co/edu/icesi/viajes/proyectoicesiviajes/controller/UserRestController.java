package co.edu.icesi.viajes.proyectoicesiviajes.controller;

import co.edu.icesi.viajes.proyectoicesiviajes.dto.UserDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.mapper.UserMapper;
import co.edu.icesi.viajes.proyectoicesiviajes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/users")
public class UserRestController {

    @Autowired
    private UserService service;

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserDTO userDTO){
        try{
            return service.save(userDTO).getName();
        }catch (Exception e){
            return e.getMessage();
        }
    }

}
