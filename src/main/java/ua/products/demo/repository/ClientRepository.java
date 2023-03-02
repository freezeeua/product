package ua.products.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.products.demo.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
