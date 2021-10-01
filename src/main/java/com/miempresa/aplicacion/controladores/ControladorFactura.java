 package com.miempresa.aplicacion.controladores;

import com.miempresa.aplicacion.modelos.RepositorioFactura;
import com.miempresa.aplicacion.modelos.Factura;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ControladorFactura {
    
    private final RepositorioFactura repositorioFactura;
    
    @GetMapping("/facturas") //path del controlador
    public String getTodasLasFacturas(Model model){
        Iterable<Factura> facturas = repositorioFactura.findAll();
        model.addAttribute("facturas",facturas);
        return "vistaFactura";
    }    
    
    @GetMapping("/facturas/{numeroFactura}") //path del controlador
    public String getFacturaByNumero(@PathVariable String numeroFactura, Model model){
        Factura facturas = repositorioFactura.findByNumeroFactura(numeroFactura);
        model.addAttribute("facturas",facturas);
        return "vistaFactura";
    }
    
    
}
