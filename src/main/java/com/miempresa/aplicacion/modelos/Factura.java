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
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="t_ventas")
public class Factura {
    @Getter
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Long idVenta;
    
    @Getter
    @Setter @Column(name ="numero_factura")
    private String numeroFactura;
    
    @Getter    
    @Setter @ManyToOne(optional = false) @JoinColumn(name = "cod_producto")
    private Producto producto;
    
    @Getter 
    @Setter @Column(name = "fecha_venta")  
    private Date fechaVenta; 
    
    @Getter
    @Setter @ManyToOne(optional = false) @JoinColumn(name = "cod_vendedor") 
    private Vendedor vendedor;
    
    @Getter
    @Setter @Column(name = "valor_factura") 
    private Float valorFactura;

    public String getCodFactura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
