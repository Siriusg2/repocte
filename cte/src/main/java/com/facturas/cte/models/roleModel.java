package com.facturas.cte.models;

import lombok.*;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

@Data
@Entity
@Table(name = "roles")
@SequenceGenerator(name = "roles_sequence", sequenceName = "roles_sequence", allocationSize = 1)
public class RoleModel {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_sequence")
    @Column(name = "role_id", unique = true, updatable = false)
    private Long id;
    @Column(name = "role_name", unique = true, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "role")
    @JsonBackReference
    private List<UsuarioModel> usuarios;
    
}