package com.inventario.gestioninventario.repositories;

import com.inventario.gestioninventario.controllers.ProductoController;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<ProductoController, Long> {

}
