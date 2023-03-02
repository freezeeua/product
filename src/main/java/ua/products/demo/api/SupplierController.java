package ua.products.demo.api;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.products.demo.data.IdData;
import ua.products.demo.data.SupplierClientData;
import ua.products.demo.model.Supplier;
import ua.products.demo.service.SupplierService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/supplier")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return ResponseEntity.ok().body(supplierService.getAllSuppliers());
    }

    @PostMapping
    public ResponseEntity<IdData> addSupplier(HttpServletRequest request,
                                              @RequestBody SupplierClientData supplierClientData) {
        supplierService.addSupplier(supplierClientData);
        var uri = URI.create(request.getRequestURI());
        return ResponseEntity.created(uri).build();
    }

}
