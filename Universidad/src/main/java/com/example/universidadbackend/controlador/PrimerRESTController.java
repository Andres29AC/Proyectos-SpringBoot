package com.example.universidadbackend.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController es una anotación que nos permite indicarle a Spring
//que esta clase es un controlador de Spring y que debe ser
//manejado por el contenedor de Spring
@RestController
@RequestMapping("/restapi")
public class PrimerRESTController {
    @GetMapping("/saludar")
    public String saludar() {
        return "Hola Mundo";
    }
}
