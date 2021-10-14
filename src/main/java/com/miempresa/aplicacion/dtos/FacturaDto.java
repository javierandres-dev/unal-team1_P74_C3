package com.miempresa.aplicacion.dtos;

import java.sql.Date;
import lombok.Data;

@Data
public class FacturaDto {

    private String numeroFactura;
    private String producto;
    private Date fechaVenta;
    private String vendedor;
    private Float valorFactura;
}
