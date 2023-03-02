package ua.products.demo.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.products.demo.model.Order;
import ua.products.demo.model.Sell;
import ua.products.demo.service.SellService;

import java.util.List;

@RestController
@RequestMapping("/api/sell")
@RequiredArgsConstructor
public class SellController {

    private final SellService sellService;

    @GetMapping
    public ResponseEntity<List<Sell>> getAllSells() {
        return ResponseEntity.ok().body(sellService.getAllSells());
    }

}
