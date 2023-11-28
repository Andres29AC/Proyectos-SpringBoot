package com.abimportapp.tienda.infrastructure.mapper;

import com.abimportapp.tienda.domain.Usuario;
import com.abimportapp.tienda.infrastructure.entity.UsuarioEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    @Mappings(
            {
                    @Mapping(source = "id", target = "id"),
                    @Mapping(source = "username", target = "username"),
                    @Mapping(source = "firstName", target = "firstName"),
                    @Mapping(source = "lastName", target = "lastName"),
                    @Mapping(source = "email", target = "email"),
                    @Mapping(source = "address", target = "address"),
                    @Mapping(source = "cellphone", target = "cellphone"),
                    @Mapping(source = "password", target = "password"),
                    @Mapping(source = "userType", target = "userType"),
                    @Mapping(source = "dateCreated", target = "dateCreated")

            }
    )
    Usuario toUser(UsuarioEntity userEntity);

    Iterable<Usuario> toUsers( Iterable<UsuarioEntity> userEntities);

    @InheritInverseConfiguration
    UsuarioEntity toUserEntity( Usuario user);
}
