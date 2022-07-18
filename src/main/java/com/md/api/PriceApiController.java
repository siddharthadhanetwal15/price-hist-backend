package com.md.api;

import com.md.model.Price;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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

    @org.springframework.beans.factory.annotation.Autowired
    public PriceApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addPrice(@Parameter(in = ParameterIn.DEFAULT, description = "Price object that needs to be added", required=true, schema=@Schema()) @Valid @RequestBody Price body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deletePrice(@Parameter(in = ParameterIn.PATH, description = "Price id to delete", required=true, schema=@Schema()) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Price>> getPrices() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Price>>(objectMapper.readValue("[ {\n  \"instrument\" : \"IFFB\",\n  \"id\" : 0,\n  \"type\" : \"high\",\n  \"value\" : 10.2\n}, {\n  \"instrument\" : \"IFFB\",\n  \"id\" : 0,\n  \"type\" : \"high\",\n  \"value\" : 10.2\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Price>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Price>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updatePrice(@Parameter(in = ParameterIn.DEFAULT, description = "Price object that needs to be added", required=true, schema=@Schema()) @Valid @RequestBody Price body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
