package com.inventario.gestioninventario.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "producto")
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    private BigDecimal precio;

    private Integer cantidadStock;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaEntity categoria;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
}
