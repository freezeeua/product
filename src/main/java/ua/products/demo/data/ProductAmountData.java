package ua.products.demo.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductAmountData {

    @JsonProperty(value = "user_id")
    private Long userId;

    @JsonProperty(value = "product_id")
    private Long productId;

    private int amount;

}
