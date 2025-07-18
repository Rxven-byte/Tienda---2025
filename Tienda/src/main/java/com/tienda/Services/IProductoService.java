package com.tienda.Services;

import java.util.List; 
import com.tienda.entities.Producto;
import java.util.Optional;

/**
 *
 * @author XSF
 */
public interface IProductoService {

    public List<Producto> findAll();
    public Producto save (Producto producto);
    public Optional <Producto> getById (Long Id);
    public Optional <Producto> delete (Long Id);
    public Optional <Producto> update (Long id,Producto producto);

}