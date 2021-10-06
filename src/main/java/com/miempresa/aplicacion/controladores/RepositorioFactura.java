package com.miempresa.aplicacion.modelos;

import org.springframework.data.repository.CrudRepository;

public interface RepositorioFactura extends CrudRepository<Factura,String> {
    
    Factura findByNumeroFactura(String numeroFactura);
}
