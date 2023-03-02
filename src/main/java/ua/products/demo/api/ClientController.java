package ua.products.demo.api;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.products.demo.data.IdData;
import ua.products.demo.data.SupplierClientData;
import ua.products.demo.model.Client;
import ua.products.demo.service.ClientService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok().body(clientService.getAllClients());
    }

    @PostMapping
    public ResponseEntity<IdData> addClient(HttpServletRequest request,
                                              @RequestBody SupplierClientData supplierClientData) {
        clientService.addClient(supplierClientData);
        var uri = URI.create(request.getRequestURI());
        return ResponseEntity.created(uri).build();
    }

}
