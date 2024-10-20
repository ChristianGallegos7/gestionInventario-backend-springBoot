package com.inventario.gestioninventario.services.impl;

import com.inventario.gestioninventario.entities.ProductoEntity;
import com.inventario.gestioninventario.repositories.ProductoRepository;
import com.inventario.gestioninventario.services.ProductoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public ProductoEntity crearProducto(ProductoEntity producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Page<ProductoEntity> obtenerTodosLosProductos(Pageable pageable) {
        return productoRepository.findAll(pageable);
    }

    @Override
    public Optional<ProductoEntity> obtenerProductoPorId(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public ProductoEntity actualizarProducto(Long id, ProductoEntity productoActualizado) {
        return productoRepository.findById(id)
                .map(productoExistente -> {
                    productoExistente.setNombre(productoActualizado.getNombre());
                    productoExistente.setDescripcion(productoActualizado.getDescripcion());
                    productoExistente.setPrecio(productoActualizado.getPrecio());
                    productoExistente.setCantidadStock(productoActualizado.getCantidadStock());
                    productoExistente.setCategoria(productoActualizado.getCategoria());
                    return productoRepository.save(productoExistente);
                })
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado con id: " + id));
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
