package com.miempresa.aplicacion.controladores;

import com.miempresa.aplicacion.modelos.Producto;
import org.springframework.data.repository.CrudRepository;


public interface RepositorioProducto extends CrudRepository<Producto,String> {
    
}
