package com.facturas.cte.models;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;
import lombok.*;


@Data
@Entity
@Table(name = "clientes")
@SequenceGenerator(name = "clientes_sequence", sequenceName = "clientes_sequence", allocationSize = 1)
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientes_sequence")
    @Column(name = "cliente_id", unique = true, updatable = false)
    private Long idCliente;

    @Column(name = "cedula_ruc_cliente", unique = true)
    private String identificacion;
    private String nombre;
    private String direccion;
    private String telefono;
    @Column(name = "correo_cliente", unique = true)
    private String correo;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<FacturaModel> factura;


}
