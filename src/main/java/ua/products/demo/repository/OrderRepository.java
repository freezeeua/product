package ua.products.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.products.demo.model.Order;
import ua.products.demo.model.Product;

public interface OrderRepository extends JpaRepository<Order, Long> {

     void deleteOrderByProduct(Product product);

}
