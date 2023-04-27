package com.ecommerce.app.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.app.backend.model.Producto;
import com.ecommerce.app.backend.repository.ProductoRepositorio;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepositorio productoRepositorio;
	
	public Producto create(Producto producto) {
		
		return productoRepositorio.save(producto);
	}
	
	public List<Producto> getAllProductos(){
		
		return productoRepositorio.findAll();
	}
	
	public void delete(Producto producto) {
		productoRepositorio.delete(producto);
	}
	
	public Optional<Producto> findById(Long id){
		
		return productoRepositorio.findById(id);
	}
	
	public void update(Producto producto) {
		
		productoRepositorio.save(producto);
	}
	
}
