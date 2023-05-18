package com.facturas.cte.models;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "productos")
@SequenceGenerator(name = "productos_sequence", sequenceName = "productos_sequence", allocationSize = 1)
public class productoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productos_sequence")
    @Column(name = "producto_id", unique = true, updatable = false)
    private Long idProducto;
    private String codigo;
    private String descripcion;
    private String categoria;


    @OneToMany(mappedBy = "producto")
    
    private List<detalleModel> detalle;
}
