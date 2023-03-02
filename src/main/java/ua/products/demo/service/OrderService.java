package ua.products.demo.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.products.demo.model.Order;
import ua.products.demo.model.Product;
import ua.products.demo.repository.OrderRepository;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    public void deleteOrder(Product product) {
        orderRepository.deleteOrderByProduct(product);
    }

}
