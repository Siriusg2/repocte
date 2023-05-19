package com.facturas.cte.models;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Entity
@Table(name = "facturas")
@SequenceGenerator(name = "facturas_sequence", sequenceName = "facturas_sequence", allocationSize = 1)
public class FacturaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "facturas_sequence")
    @Column(name = "factura_id", unique = true, updatable = false)
    private Long idFactura;
    private String establecimiento;
    private String puntoEmision;


    @Column(name = "num_factura", unique = true, updatable = false)
    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{9}", message = "El número de factura debe tener el formato correcto ej. 123-456-789012345")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String numeroFactura;

    @Column(name = "fecha_factura", unique = true, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "La fecha de la factura debe ser presente o pasada")
    private Date fecha;

  
    @Column(nullable = false)
    private BigDecimal subtotal;
    @Column(nullable = false)
    private BigDecimal totalIVA;
    @Column(nullable = false)
    private BigDecimal total;
    
    
    @OneToMany(mappedBy = "facturas")
    private List<DetalleModel> detalles;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;
}
