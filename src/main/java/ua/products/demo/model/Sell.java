package ua.products.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "sells")
public class Sell {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonProperty(value = "product_id")
    private Product product;

    @ManyToOne
    @JsonProperty(value = "client_id")
    private Client client;

    private int amount;

    private LocalDateTime timestamp;

}
