package com.miempresa.aplicacion.modelos;

import com.miempresa.aplicacion.modelos.Producto;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioProducto extends CrudRepository<Producto, String> {

    Producto findByCodProducto(String codProducto);

}
