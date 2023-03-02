package ua.products.demo.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateProductData {

    @JsonProperty(value = "supplier_id")
    private Long supplierId;

    private String name;

    private String description;

    private double price;

    private int amount;

}
