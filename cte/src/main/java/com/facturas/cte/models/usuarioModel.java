package com.facturas.cte.models;
import lombok.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

@Data
@Entity
@Table(name = "usuarios")
@SequenceGenerator(name = "usuarios_sequence", sequenceName = "usuarios_sequence", allocationSize = 1)
public class UsuarioModel {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarios_sequence")
    @Column(name = "usuario_id", unique = true, updatable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;


    @Column(nullable = false)
    private String password;
    

@ManyToOne
@JsonManagedReference
@JoinColumn(name = "role_id")
private RoleModel role;
}
