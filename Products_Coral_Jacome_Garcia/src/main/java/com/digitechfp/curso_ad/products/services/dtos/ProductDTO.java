package com.digitechfp.curso_ad.products.services.dtos;

import com.digitechfp.curso_ad.products.model.entities.Product;
import lombok.Data;

@Data
public class ProductDTO {
    private int id;
    private String name;
    private int precio;
    private int stock;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getNombre();
        this.precio = product.getPrecio();
        this.stock = product.getStock();
    }
}
