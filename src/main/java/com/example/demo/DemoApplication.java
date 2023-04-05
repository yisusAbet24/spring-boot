package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {
  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }



  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "mundo") String name) {
    return String.format("hola %s!", name);
  }

  @RestController
  public class EjemploController {


    //ejemplo con query los parámetros de consulta en una URL se pasan mediante una sintaxis de clave-valor separados por "&"

    @GetMapping("/ejemplo")
    public String ejemplo(@RequestParam("param1") String parametro1, @RequestParam("param2") int parametro2) {
      return "Los valores de los parámetros son: " + parametro1 + " y " + parametro2;
    }

    //ejemplo con parametro

    @GetMapping("/saludo/{nombre}")
    public String saludo(@PathVariable String nombre) {
      return "¡Hola, " + nombre + "!";
    }

  }
}