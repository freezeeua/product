package ua.products.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.products.demo.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
