package com.miempresa.aplicacion.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorIndex {
    
    @GetMapping("/") //path del controlador
    public String elIndice(){
        return "vistaIndex";
    }
    
}
