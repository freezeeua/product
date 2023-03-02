package ua.products.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.products.demo.model.Sell;

public interface SellRepository extends JpaRepository<Sell, Long> {
}
