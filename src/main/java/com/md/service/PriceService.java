package com.md.service;

import com.md.model.Price;
import com.md.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {
    @Autowired
    private PriceRepository priceRepository;

    @Cacheable("prices")
    public List<Price> getPrices(){
        return priceRepository.findAll();
    }
}
