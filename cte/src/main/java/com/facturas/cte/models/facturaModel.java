package com.facturas.cte.models;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    private String numeroFactura;


    @Column(name = "fecha_factura", unique = true, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

  
    
    private BigDecimal subtotal;
    private BigDecimal totalIVA;
    private BigDecimal total;
    
    
    @OneToMany(mappedBy = "detalles")
    private List<DetalleModel> detalles;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;
}
