package com.miempresa.aplicacion.controladores;

import com.miempresa.aplicacion.modelos.RepositorioFactura;
import com.miempresa.aplicacion.modelos.Factura;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

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
    
    @GetMapping("/crear/facturas") //path del controlador
    public String crearVendedor(Model model){
        model.addAttribute("vendedor",new Vendedor());
        return "vistaCrearVendedor";
    }        
    @PostMapping("/crear/facturas")
    public RedirectView procesarVendedor(@ModelAttribute Vendedor vendedor) {
        Vendedor vendedorGuardado;
        vendedorGuardado = repositorioVendedor.save(vendedor);
        if (vendedorGuardado == null){
            return new RedirectView("/crear/vendedor", true);
        }
        return new RedirectView("/vendedores/"+vendedorGuardado.getCodVendedor(),true);
    }
    
    @GetMapping("/crear/factura") //path del controlador
    public String crearFactura(Model model){
        model.addAttribute("factura",new Factura());
        return "vistaCrearFactura";
    }
    @PostMapping("/crear/factura")
    public RedirectView procesarFactura(@ModelAttribute Factura factura){
        Factura facturaGuardada;
        facturaGuardada = repositorioFactura.save(factura);
        if (facturaGuardada == null){
            return new RedirectView("/crear/factura", true);
        }
        return new RedirectView("/facturas/"+facturaGuardada.getIdVenta(),true);
    }
    
}
