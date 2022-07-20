package com.md.api;

import com.md.model.Price;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.md.repository.PriceRepository;
import com.md.service.PriceService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import springfox.documentation.annotations.Cacheable;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-07-18T11:15:17.747Z[GMT]")
@RestController
public class PriceApiController implements PriceApi {

    private static final Logger log = LoggerFactory.getLogger(PriceApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private PriceService priceService;

    @org.springframework.beans.factory.annotation.Autowired
    public PriceApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addPrice(@Parameter(in = ParameterIn.DEFAULT, description = "Price object that needs to be added", required=true, schema=@Schema()) @Valid @RequestBody Price body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                priceRepository.save(body);
                return new ResponseEntity<Void>(HttpStatus.CREATED);
            } catch (Exception e) {
                log.error("Exception: ", e);
                return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Void> deletePrice(@Parameter(in = ParameterIn.PATH, description = "Price id to delete", required=true, schema=@Schema()) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                priceRepository.deleteById(id);
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            } catch (Exception e) {
                log.error("Exception: ", e);
                return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Price>> getPrices() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Price>>(priceService.getPrices(), HttpStatus.OK);
                //return new ResponseEntity<List<Price>>(objectMapper.readValue("[ {\n  \"instrument\" : \"IFCL\",\n  \"id\" : 1,\n  \"type\" : \"low\",\n  \"value\" : 99.8\n}, {\n  \"instrument\" : \"IFFB\",\n  \"id\" : 2,\n  \"type\" : \"high\",\n  \"value\" : 10.2\n} ]", List.class), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Exception: ", e);
                return new ResponseEntity<List<Price>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Price>>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Void> updatePrice(@Parameter(in = ParameterIn.DEFAULT, description = "Price object that needs to be added", required=true, schema=@Schema()) @Valid @RequestBody Price body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                priceRepository.save(body);
                return new ResponseEntity<Void>(HttpStatus.OK);
            } catch (Exception e) {
                log.error("Exception: ", e);
                return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

}
