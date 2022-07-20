package com.md;

import com.md.api.PriceApiController;
import com.md.configuration.HomeController;
import com.md.model.Price;
import com.md.repository.PriceRepository;
import com.md.service.PriceService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)//revisit
@RunWith(SpringRunner.class)
public class TestingWebApplicationTests {
    @LocalServerPort
    private int port;
    /*@Value("${server.port}:9090")
    private String port;*/
    @Autowired
    public TestRestTemplate restTemplate;

    @Autowired
    PriceService priceService;

    @Autowired
    PriceRepository priceRepository;

    @Before
    public void setUp(){
        Price price = new Price();
        price.setInstrument("IFCL");
        price.setType(Price.TypeEnum.LOW);
        price.setValue(BigDecimal.valueOf(23.4));
        priceRepository.save(price);
    }
    @Test
    public void getPricesTest() {
        assertThat(this.restTemplate.getRestTemplate().getForEntity("http://localhost:" + port + "/price-hist/price", String.class).getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void getPriceServiceTest(){
        assertThat(priceService.getPrices().size()).isEqualTo(1);
    }

}
