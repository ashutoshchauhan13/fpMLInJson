package org.fpml;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


@RestController
public class FpMLInJsonRestController {


    @PostMapping(value = "/trade",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public FpMLInJsonResponse trade(@RequestBody FpMLInJsonRequest requestBody){
        System.out.println("request body= " + requestBody.toString());
        var originalXML = StringEscapeUtils.unescapeXml(requestBody.getPayload());
        System.out.println("original xml= " + originalXML);
        FpMLInJsonResponse response = new FpMLInJsonResponse();
         response.setResponse(requestBody.getPayload());
        return response;
    }

    @GetMapping(value = "/trade",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public String trade(){
        System.out.println("request called");
        return"{\"message\":\"hello\"}";
    }
}
