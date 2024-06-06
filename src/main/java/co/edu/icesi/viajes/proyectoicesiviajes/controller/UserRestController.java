package co.edu.icesi.viajes.proyectoicesiviajes.controller;

import co.edu.icesi.viajes.proyectoicesiviajes.config.UserAuthenticationProvider;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.ClientDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.CredentialsDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.UserDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.mapper.UserMapper;
import co.edu.icesi.viajes.proyectoicesiviajes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/users")
public class UserRestController {

    @Autowired
    private UserService service;

    @Autowired
    private UserAuthenticationProvider userAuthenticationProvider;

    @PostMapping(path = "/save")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
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
        userDto.setToken(userAuthenticationProvider.createToken(userDto));
        return ResponseEntity.ok(userDto);
    }

    @GetMapping(path = "/all")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VIEWER', 'AGENT')")
    public List<UserDTO> getAll() {
        System.out.println( service.findByStatus("Active"));
        return service.findByStatus("Active");
    }

    @PostMapping(path = "/delete")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void deleteClient(@RequestBody Long id) throws Exception {
        System.out.println("entro");
        System.out.println(id);
        service.deleteById(id);
    }

    @PostMapping(path = "/create")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public UserDTO createUser(@RequestBody UserDTO user) throws Exception {
        System.out.println(user);
        System.out.println("entro");
        return service.save(user);
    }

    @PostMapping(path = "/update")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public UserDTO updateUser(@RequestBody UserDTO user) throws Exception {
        System.out.println("UPDATE");
        return service.update(user);
    }

    @PostMapping(path = "/get")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public UserDTO updateUser(@RequestBody Long id) throws Exception {
        System.out.println("find by id");
        return service.findById(id);
    }

}
