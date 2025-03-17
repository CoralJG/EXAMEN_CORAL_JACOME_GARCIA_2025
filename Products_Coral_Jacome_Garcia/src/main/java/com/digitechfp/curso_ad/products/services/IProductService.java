package com.digitechfp.curso_ad.products.services;

import com.digitechfp.curso_ad.products.model.entities.Product;
import com.digitechfp.curso_ad.products.services.dtos.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<ProductDTO> getAllProducts();

    Optional<ProductDTO> getProductById(Integer id);

    ProductDTO createProduct(Product product);

    Optional<ProductDTO> updateProduct(Integer id, Product product);

    boolean deleteProduct(Integer id);
}
