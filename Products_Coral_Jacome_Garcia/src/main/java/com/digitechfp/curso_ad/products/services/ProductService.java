package com.digitechfp.curso_ad.products.services;
import com.digitechfp.curso_ad.products.model.daos.IProductDAO;
import com.digitechfp.curso_ad.products.model.entities.Product;
import com.digitechfp.curso_ad.products.services.dtos.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {
    private final IProductDAO productDAO;
    @Autowired
    public ProductService(IProductDAO productDAO) {
        this.productDAO = productDAO;
    }
    @Override
    public List<ProductDTO> getAllProducts() {
        return productDAO.findAll().stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDTO> getProductById(Integer id) {
        return productDAO.findById(id).map(ProductDTO::new);
    }

    @Override
    public ProductDTO createProduct(Product product) {
        return new ProductDTO(productDAO.save(product));
    }

    @Override
    public Optional<ProductDTO> updateProduct(Integer id, Product product) {
        if (productDAO.existsById(id)) {
            product.setId(id);
            return Optional.of(new ProductDTO(productDAO.save(product)));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteProduct(Integer id) {
        if (productDAO.existsById(id)) {
            productDAO.deleteById(id);
            return true;
        }
        return false;
    }

}



