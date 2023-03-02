package ua.products.demo.api;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.products.demo.data.CreateProductData;
import ua.products.demo.data.IdData;
import ua.products.demo.data.ProductAmountData;
import ua.products.demo.model.Product;
import ua.products.demo.service.ProductService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping(value = "/buy")
    public ResponseEntity<?> buyProduct(@RequestBody ProductAmountData amountData) {
        boolean isSell = productService.buyProduct(amountData);
        return isSell ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok().body(productService.getAllProducts());
    }

    @PostMapping
    public ResponseEntity<IdData> addProduct(HttpServletRequest request,
                                              @RequestBody CreateProductData productData) {
        productService.addProduct(productData);
        var uri = URI.create(request.getRequestURI());
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteProduct(@RequestBody IdData data) {
        productService.deleteProduct(data);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<?> changeProductAmount(@RequestBody ProductAmountData amountData) {
        productService.changeProductAmount(amountData);
        return ResponseEntity.ok().build();
    }

}
