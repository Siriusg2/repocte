package com.facturas.cte.models;

import java.math.BigDecimal;

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
public class detalleModel {

  @Id
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "detalles_sequence"
  )
  @Column(name = "detalle_id", unique = true, updatable = false)
  private Long idDetalle;

  private BigDecimal cantidad;
  private String unidadMedida;
  private BigDecimal precio;
  private BigDecimal iva;
  private BigDecimal subtotal;

  @ManyToOne
  @JoinColumn(name = "factura_id")
  private facturaModel detalles;

  @ManyToOne
  @JoinColumn(name = "producto_id")
  private productoModel producto;
}
