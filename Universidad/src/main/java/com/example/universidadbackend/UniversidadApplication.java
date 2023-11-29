package com.example.universidadbackend;

import com.example.universidadbackend.modelo.entidades.Alumno;
import com.example.universidadbackend.modelo.entidades.Direccion;
import com.example.universidadbackend.modelo.entidades.Persona;
import com.example.universidadbackend.servicios.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UniversidadApplication {
    @Autowired
    //Para que le inyecte a travesde su clase de servicio
    private AlumnoDAO servicio;
    public static void main(String[] args) {
        String[] beanDefinitionNames =SpringApplication.run(UniversidadApplication.class, args).getBeanDefinitionNames();
        //for (String beanDefinitionName : beanDefinitionNames) {
          //  System.out.println(beanDefinitionName);
        //}
    }
//    @Bean
//    public CommandLineRunner runner(){
//        return args -> {
//            //Direccion direccion = new Direccion("Huanchaco","45","012","80","2","Balneario");
//            //Persona alumno = new Alumno(null, "Alejandra", "Sosa", "3432224","ale65@hotmail.com","6534521",direccion);
//            //Persona guardar=servicio.save(alumno);
//            //System.out.println(guardar.toString());
//            List<Persona> alumnos = (List<Persona>) servicio.findAll();
//            //for (Persona alumno : alumnos) {
//             //   System.out.println(alumno.toString());
//           // }
//            //Esto nos permite traer todos los alumnos
//            alumnos.forEach(System.out::println);
//        };
//    }
}





