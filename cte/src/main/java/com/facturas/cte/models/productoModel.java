package com.facturas.cte.models;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "productos")
@SequenceGenerator(name = "productos_sequence", sequenceName = "productos_sequence", allocationSize = 1)
public class ProductoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productos_sequence")
    @Column(name = "producto_id", unique = true, updatable = false)
    private Long idProducto;
    
    @Column(nullable = false)
    private String codigo;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private String categoria;


    @ManyToOne
    @JoinColumn(name = "detalle_id")
    
    private List<DetalleModel> detalles;
}
