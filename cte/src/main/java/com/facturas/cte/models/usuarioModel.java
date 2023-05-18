package com.facturas.cte.models;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name = "usuarios")
@SequenceGenerator(name = "usuarios_sequence", sequenceName = "usuarios_sequence", allocationSize = 1)
public class usuarioModel {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarios_sequence")
    @Column(name = "usuario_id", unique = true, updatable = false)
    private Long id;
    private String nombre;
    

@ManyToOne
@JoinColumn(name = "role_id")
private roleModel role;
}
