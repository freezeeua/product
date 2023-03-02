package ua.products.demo.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.products.demo.model.Order;
import ua.products.demo.model.Sell;
import ua.products.demo.repository.SellRepository;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class SellService {

    private final SellRepository sellRepository;

    public List<Sell> getAllSells() {
        return sellRepository.findAll();
    }

    public void createSell(Sell sell) {
        sellRepository.save(sell);
    }
}
