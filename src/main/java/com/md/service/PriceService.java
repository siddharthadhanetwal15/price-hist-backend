package com.md.service;

import com.md.model.Price;
import com.md.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PriceService {
    @Autowired
    private PriceRepository priceRepository;

    @Cacheable("prices")//only get called first time.. until cache get evicted
    public Price getPrice(Long id){
        return priceRepository.findById(id).get();
    }
}
