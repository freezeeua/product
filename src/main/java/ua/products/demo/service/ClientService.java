package ua.products.demo.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.products.demo.data.IdData;
import ua.products.demo.data.SupplierClientData;
import ua.products.demo.model.Client;
import ua.products.demo.model.Supplier;
import ua.products.demo.repository.ClientRepository;

import java.nio.file.FileSystemNotFoundException;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> {
            throw new FileSystemNotFoundException("Client not found");
        });
    }

    public IdData addClient(SupplierClientData supplierClientData) {
        var client = Client.builder()
                .name(supplierClientData.getName())
                .address(supplierClientData.getAddress())
                .details(supplierClientData.getDetails())
                .build();
        clientRepository.save(client);
        var idData = new IdData();
        idData.setId(client.getId());
        return idData;
    }

}
