package com.example.universidadbackend;


import com.example.universidadbackend.modelo.entidades.CarreraProfesional;
import com.example.universidadbackend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CarreraComandos implements CommandLineRunner {
    @Autowired
    private CarreraDAO servicio;
    @Override
    public void run(String... args) throws Exception {
        //CarreraProfesional ingeSistemas = new CarreraProfesional(null, "Ingeniería de Sistemas",50,5);
        //CarreraProfesional guardar=servicio.save(ingeSistemas);
        //System.out.println(guardar.toString());

    }
}
//TODO:@Component es una anotación que nos permite indicarle a Spring
//TODO:que esta clase es un componente de Spring y que debe ser
//TODO:manejado por el contenedor de Spring