package com.inventario.gestioninventario.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "proveedor")
public class ProveedorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String contacto;
    private String telefono;
    private String email;
    private String direccion;
}
