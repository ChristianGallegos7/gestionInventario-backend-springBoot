package com.inventario.gestioninventario.repositories;

import com.inventario.gestioninventario.controllers.ProductoController;
import com.inventario.gestioninventario.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {
    List<ProductoEntity> findByNombreContainingIgnoreCase(String nombre);
    List<ProductoEntity> findByCategoriaId(Long categoriaId);
    List<ProductoEntity> findByPrecioBetween(BigDecimal precioMinimo, BigDecimal precioMaximo);
    List<ProductoEntity> findByCantidadStockLessThan(int umbral);
    boolean existsByNombreIgnoreCase(String nombre);

    @Query("SELECT SUM(p.precio * p.cantidadStock) FROM ProductoEntity p")
    BigDecimal calcularValorTotalInventario();
}
