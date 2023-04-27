package com.ecommerce.app.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.app.backend.model.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

}
