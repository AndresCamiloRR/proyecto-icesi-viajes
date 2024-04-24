package co.edu.icesi.viajes.proyectoicesiviajes.mapper;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.User;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> toUser(List<UserDTO> userDTOList);
    List<UserDTO> toUserDTO(List<User> userList);
    User toUser(UserDTO userDTO);
    UserDTO toUserDTO(User user);

}
