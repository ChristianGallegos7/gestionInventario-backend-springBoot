package com.inventario.gestioninventario.services;

import com.inventario.gestioninventario.entities.ProductoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductoService {

    //Operaciones crud basico

    //1. Crear un producto
    ProductoEntity crearProducto(ProductoEntity producto);
    //Buscar todos los productos
    Page<ProductoEntity> obtenerTodosLosProductos(Pageable pageable);
    //2. Buscar un Producto
    Optional<ProductoEntity> obtenerProductoPorId(Long id);
    //3. Actualizar un Producto
    ProductoEntity actualizarProducto(Long id, ProductoEntity productoActualizado);
    //4. Eliminar un Producto
    void eliminarProducto(Long id);
}
