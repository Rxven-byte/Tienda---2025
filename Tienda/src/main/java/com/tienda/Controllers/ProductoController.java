package com.tienda.Controllers;

/**
 *
 * @author XSF
 */
import com.tienda.Services.ProductoService;
import com.tienda.entities.Producto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    ProductoService productoServiceManager;

    @GetMapping()
    public List<Producto> listarProductos() {
        return this.productoServiceManager.findAll();
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoId(@PathVariable Long id) {
        return this.productoServiceManager.getById(id).get();
    }

    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Producto> encontrado = productoServiceManager.getById(id);

        if (encontrado.isPresent()) {
            return ResponseEntity.ok(encontrado.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Producto> save(@RequestBody Producto producto) {
        Producto newProducto = productoServiceManager.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProducto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> deleteProducto(@PathVariable Long id) {
        Optional<Producto> optionalProducto = this.productoServiceManager.delete(id);

        if (optionalProducto.isPresent()) {
            return ResponseEntity.ok(optionalProducto.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
