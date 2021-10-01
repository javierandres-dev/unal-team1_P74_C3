package com.miempresa.aplicacion.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="t_ventas")
public class Factura {
    @Getter @Setter @Id @Column(name = "id_venta")
    private String idVenta;
    @Getter @Setter @Column(name = "numero_factura")
    private String numeroFactura;
    @Getter @Setter @Column(name = "cod_producto")
    private String codigoProducto;
    @Getter @Setter @Column(name = "fecha_venta")
    private String fechaVenta; 
    @Getter @Setter @Column(name = "cod_vendedor")
    private String codigoVendedor;
}
