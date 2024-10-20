package com.inventario.gestioninventario.controllers;

import com.inventario.gestioninventario.entities.ProductoEntity;
import com.inventario.gestioninventario.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<ProductoEntity> crearProducto(@RequestBody ProductoEntity producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.crearProducto(producto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoEntity> obtenerPorId(@PathVariable Long id){
        Optional<ProductoEntity> optional = productoService.obtenerProductoPorId(id);

        if(optional.isPresent()){
            return ResponseEntity.ok(optional.get());
        }

        return ResponseEntity.notFound().build();
    }


}
