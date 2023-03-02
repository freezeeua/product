package ua.products.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.products.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
