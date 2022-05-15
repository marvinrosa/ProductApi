package dev.marvinrosa.productsapi.repository;

import dev.marvinrosa.productsapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
