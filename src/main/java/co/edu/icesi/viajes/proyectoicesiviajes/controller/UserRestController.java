package co.edu.icesi.viajes.proyectoicesiviajes.controller;

import co.edu.icesi.viajes.proyectoicesiviajes.config.UserAuthenticationProvider;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.CredentialsDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.UserDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.mapper.UserMapper;
import co.edu.icesi.viajes.proyectoicesiviajes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/users")
public class UserRestController {

    @Autowired
    private UserService service;

    @Autowired
    private UserAuthenticationProvider userAuthenticationProvider;

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserDTO userDTO){
        try{
            return service.save(userDTO).getName();
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @PostMapping(path = "/login")
    public ResponseEntity<UserDTO> login(@RequestBody CredentialsDTO credentialsDto) {
        System.out.println(credentialsDto);
        UserDTO userDto = service.login(credentialsDto);
        userDto.setToken(userAuthenticationProvider.createToken(userDto.getLogin()));
        return ResponseEntity.ok(userDto);
    }

}
