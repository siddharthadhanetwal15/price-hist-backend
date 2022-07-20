package com.md;

import com.md.api.PriceApiController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest//revisit
public class PriceBackendTest {
    @Autowired
    PriceApiController priceApiController;
    @Test
    public void contextLoads() {
        assertThat(priceApiController).isNotNull();
    }
}
