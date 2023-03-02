package ua.products.demo.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.products.demo.data.CreateProductData;
import ua.products.demo.data.IdData;
import ua.products.demo.data.ProductAmountData;
import ua.products.demo.model.Order;
import ua.products.demo.model.Product;
import ua.products.demo.model.Sell;
import ua.products.demo.repository.ProductRepository;

import java.nio.file.FileSystemNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final SupplierService supplierService;
    private final OrderService orderService;
    private final ClientService clientService;
    private final SellService sellService;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> {
            throw new FileSystemNotFoundException("Product not found");
        });
    }

    public IdData addProduct(CreateProductData productData) {
        var supplier = supplierService.findById(productData.getSupplierId());
        var product = Product.builder()
                .name(productData.getName())
                .description(productData.getDescription())
                .price(productData.getPrice())
                .amount(productData.getAmount())
                .build();
        productRepository.save(product);
        var order = Order.builder()
                .supplier(supplier)
                .product(product)
                .timestamp(LocalDateTime.now())
                .build();
        orderService.createOrder(order);
        var idData = new IdData();
        idData.setId(product.getId());
        return idData;
    }

    public void deleteProduct(IdData data) {
        var product = productRepository.findById(data.getId()).orElseThrow(() -> {
            throw new FileSystemNotFoundException("not found");
        });
        orderService.deleteOrder(product);
        productRepository.delete(product);
    }

    public void changeProductAmount(ProductAmountData amountData) {
        var product = findById(amountData.getProductId());
        product.setAmount(amountData.getAmount());
        productRepository.save(product);
    }

    public boolean buyProduct(ProductAmountData amountData) {
        var product = findById(amountData.getProductId());
        if(product.getAmount() < amountData.getAmount()) {
            return false;
        }
        product.setAmount(product.getAmount() - amountData.getAmount());
        productRepository.save(product);
        var client = clientService.findById(amountData.getUserId());
        var sell = Sell.builder()
                .product(product)
                .client(client)
                .amount(amountData.getAmount())
                .timestamp(LocalDateTime.now())
                .build();
        sellService.createSell(sell);
        return true;
    }
}
