package com.miempresa.aplicacion.controladores;

import com.miempresa.aplicacion.modelos.Vendedor;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioVendedor extends CrudRepository<Vendedor,String> {
    
    Vendedor findByCodVendedor(String codVendedor);
}
