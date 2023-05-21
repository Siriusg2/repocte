package com.facturas.cte.models;

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
  private Float cantidad;

  @Column(nullable = false)
  private String unidadMedida;

  @Column(nullable = false)
  private Float precio;

  @Column(nullable = false)
  private Float iva;

  @Column(nullable = false)
  private Float subtotal;

  @ManyToOne
  @JoinColumn(name = "factura_id")
  private FacturaModel factura;

  @ManyToOne
  @JoinColumn(name = "producto_id")
  private ProductoModel producto;
}
