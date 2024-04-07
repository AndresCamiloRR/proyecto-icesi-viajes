package co.edu.icesi.viajes.proyectoicesiviajes.mapper;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Client;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    @Mapping(source = "typeNID.id", target = "typeNID")
    ClientDTO toClientDTO(Client entity);

    @Mapping(source = "typeNID", target = "typeNID.id")
    Client toClient(ClientDTO dto);
}
