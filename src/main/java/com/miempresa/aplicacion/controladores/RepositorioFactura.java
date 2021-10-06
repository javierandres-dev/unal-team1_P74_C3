package com.miempresa.aplicacion.controladores;

import com.miempresa.aplicacion.modelos.Factura;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioFactura extends CrudRepository<Factura,String> {
    
    Factura findByNumeroFactura(String numeroFactura);
}
