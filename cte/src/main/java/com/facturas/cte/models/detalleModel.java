package com.facturas.cte.models;

import java.math.BigDecimal;
import java.util.*;

import javax.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "detalles")
@SequenceGenerator(
  name = "detalles_sequence",
  sequenceName = "detalles_sequence",
  allocationSize = 1
)
public class DetalleModel {

  @Id
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "detalles_sequence"
  )
  @Column(name = "detalle_id", unique = true, updatable = false)
  private Long idDetalle;
@Column(nullable = false)
private BigDecimal cantidad;
@Column(nullable = false)
private String unidadMedida;
@Column(nullable = false)
private BigDecimal precio;
@Column(nullable = false )
private BigDecimal iva;
@Column(nullable = false)
  private BigDecimal subtotal;

  @ManyToOne
  @JoinColumn(name = "factura_id")
  private FacturaModel facturas;

  @ManyToMany
  @JoinTable(
    name = "detalle_producto",
    joinColumns = @JoinColumn(name = "detalle_id"),
    inverseJoinColumns = @JoinColumn(name = "producto_id")
  )
  private List<ProductoModel> productos;
}
