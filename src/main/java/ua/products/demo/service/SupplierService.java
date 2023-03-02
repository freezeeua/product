package ua.products.demo.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.products.demo.data.IdData;
import ua.products.demo.data.SupplierClientData;
import ua.products.demo.model.Client;
import ua.products.demo.model.Supplier;
import ua.products.demo.repository.SupplierRepository;

import java.io.FileNotFoundException;
import java.nio.file.FileSystemNotFoundException;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier findById(Long id) {
        return supplierRepository.findById(id).orElseThrow(() -> {
            throw new FileSystemNotFoundException("Supplier not found");
        });
    }

    public IdData addSupplier(SupplierClientData supplierClientData) {
        var supplier = Supplier.builder()
                .name(supplierClientData.getName())
                .address(supplierClientData.getAddress())
                .details(supplierClientData.getDetails())
                .build();
        supplierRepository.save(supplier);
        var idData = new IdData();
        idData.setId(supplier.getId());
        return idData;
    }

}
