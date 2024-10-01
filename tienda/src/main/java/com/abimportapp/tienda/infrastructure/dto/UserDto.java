package com.abimportapp.tienda.infrastructure.dto;

import com.abimportapp.tienda.domain.UserType;
import com.abimportapp.tienda.domain.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {
    private String username;
    @NotBlank(message = "Nombre is required")
    private String firstName;
    @NotBlank(message = "Apellido is required")
    private String lastName;
    @Email(message = "Debe ingresar un correo válido")
    private String email;
    @NotBlank(message = "Dirección is required")
    private String address;
    @NotBlank(message = "Celular is required")
    private String cellphone;
    @NotBlank(message = "Contraseña is required")
    private String password;

    public Usuario userDtoToUser(){
        return new Usuario(null,this.getEmail(),this.getFirstName(),this.getLastName(),this.getEmail(),this.getAddress(),this.getCellphone(),this.getPassword(), UserType.USER, LocalDateTime.now());
    }
}
