package com.digitechfp.curso_ad.products.model.daos;
import com.digitechfp.curso_ad.products.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface IProductDAO extends JpaRepository<Product, Integer> {
    Optional<Product> findByPrecio(Integer precio);
    @Query("SELECT p FROM Product p WHERE p.precio < 10")
    List<Product> dataMigrate();
}
