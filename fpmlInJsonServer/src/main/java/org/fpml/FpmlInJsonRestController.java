package org.fpml;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;


@RestController
public class FpmlInJsonRestController {


    @PostMapping(value = "/trade",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public FpmlInJsonResponse trade(@RequestBody FpmlInJsonRequest requestBody){
        System.out.println("request body= " + requestBody);
        return new FpmlInJsonResponse();
    }
}
