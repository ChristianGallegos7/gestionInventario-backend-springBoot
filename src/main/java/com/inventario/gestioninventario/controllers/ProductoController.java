package com.inventario.gestioninventario.controllers;

import com.inventario.gestioninventario.entities.ProductoEntity;
import com.inventario.gestioninventario.services.ProductoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        ProductoEntity nuevoProducto = productoService.crearProducto(producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoEntity> obtenerPorId(@PathVariable Long id){
        Optional<ProductoEntity> optional = productoService.obtenerProductoPorId(id);

        if(optional.isPresent()){
            return ResponseEntity.ok(optional.get());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<Page<ProductoEntity>> obtenerTodosLosProductos(Pageable pageable){
        Page<ProductoEntity> productos = productoService.obtenerTodosLosProductos(pageable);
        return ResponseEntity.ok(productos);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductoEntity> actualizarProducto(@PathVariable Long id, @RequestBody ProductoEntity productoActualizado){
        Optional<ProductoEntity> optional = productoService.obtenerProductoPorId(id);

        if(optional.isPresent()){
            return ResponseEntity.ok(productoService.actualizarProducto(id, productoActualizado));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
