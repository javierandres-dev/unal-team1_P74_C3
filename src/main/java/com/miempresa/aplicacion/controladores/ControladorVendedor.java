package com.miempresa.aplicacion.controladores;

import com.miempresa.aplicacion.modelos.RepositorioVendedor;
import com.miempresa.aplicacion.modelos.Vendedor;
import java.util.ArrayList;
import java.util.List;
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
@RequiredArgsConstructor(onConstructor = @__(
        @Autowired))
public class ControladorVendedor {

    private final RepositorioVendedor repositorioVendedor;

    @GetMapping("/vendedores") //path del controlador
    public String getTodosLosVendedores(Model model) {
        Iterable<Vendedor> vendedores = repositorioVendedor.findAll();
        model.addAttribute("vendedores", vendedores);
        return "vistaVendedor";
    }

    @GetMapping("/vendedores/{codigoVendedor}") //path del controlador
    public String getVendedorById(@PathVariable String codigoVendedor, Model model) {
        Vendedor vendedores = repositorioVendedor.findByCodVendedor(codigoVendedor);
        model.addAttribute("vendedores", vendedores);
        return "vistaVendedor";
    }

    @GetMapping("/crear/vendedor") //path del controlador
    public String crearVendedor(Model model) {
        model.addAttribute("vendedor", new Vendedor());
        return "vistaCrearVendedor";
    }
    
    @GetMapping("/vendedores/actualizar/{codigoVendedor}") //path del controlador
    public String updateVendedorById(@PathVariable String codigoVendedor, Model model) {
        List<String> listaVendedor = new ArrayList<>();
        listaVendedor.add(codigoVendedor);
        Iterable<Vendedor> vendedores = repositorioVendedor.findAllById(listaVendedor);
        model.addAttribute("vendedores", vendedores);
        return "vistaActualizarVendedor";
    }

    @PostMapping("/vendedores/actualizar/{codigoVendedor}")
    public RedirectView postVendedor(@ModelAttribute Vendedor Vendedor) {
        Vendedor VendedorGuardado;
        VendedorGuardado = repositorioVendedor.save(Vendedor);
        if (VendedorGuardado == null) {
            return new RedirectView("/crear/Vendedor", true);
        }
        return new RedirectView("/vendedores/" + VendedorGuardado.getCodVendedor(), true);
    }

    @GetMapping("/vendedores/eliminar/{codigoVendedor}") //path del controlador
    public String removeVendedorById(@PathVariable String codigoVendedor, Model model) {
        List<String> listaVendedor = new ArrayList<>();
        listaVendedor.add(codigoVendedor);
        Iterable<Vendedor> vendedores = repositorioVendedor.findAllById(listaVendedor);
        model.addAttribute("vendedores", vendedores);
        return "vistaEliminarVendedor";
    }
}
