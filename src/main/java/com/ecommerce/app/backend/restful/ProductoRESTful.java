package com.ecommerce.app.backend.restful;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.app.backend.model.Producto;
import com.ecommerce.app.backend.service.ProductoService;

@RestController
@RequestMapping("/api/producto/")
public class ProductoRESTful {

	@Autowired
	private ProductoService productoService;
	
	@PostMapping
	private ResponseEntity<Producto> guardar(@RequestBody Producto producto){
		
		Producto nuevoProducto = productoService.create(producto);
		
		try {
			
			return ResponseEntity.created(new URI("/api/producto/" + nuevoProducto.getId())).body(nuevoProducto);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}		
	}
	
	@GetMapping
	private ResponseEntity<List<Producto>> listarTodasLasPersona (){
		return ResponseEntity.ok(productoService.getAllProductos());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> eliminarProducto (@RequestBody Producto producto){
		productoService.delete(producto);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Producto>> listarPersonasPorID (@PathVariable ("id") Long id){
		
		return ResponseEntity.ok(productoService.findById(id));
	}
	
	@PutMapping
	public void actualizarProducto(@RequestBody Producto producto) {
		
		productoService.update(producto);
	}
}
