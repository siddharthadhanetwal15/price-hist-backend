package com.md.repository;

import com.md.model.Price;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {
    Page<Price> findByType(Price.TypeEnum typeEnum, Pageable pageable);
    Page<Price> findByInstrumentContaining(String instrument, Pageable pageable);
}
