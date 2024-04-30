package co.edu.icesi.viajes.proyectoicesiviajes.mapper;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Client;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ClientMapper {

    @Mapping(source = "typeNID.id", target = "typeNID")
    ClientDTO toClientDTO(Client entity);

    @Mapping(source = "typeNID", target = "typeNID.id")
    Client toClient(ClientDTO dto);

    @Mapping(source = "typeNID.id", target = "typeNID")
    List<ClientDTO> toClientDTO(List<Client> entity);

    @Mapping(source = "typeNID", target = "typeNID.id")
    List<Client> toClient(List<ClientDTO> dto);
}
