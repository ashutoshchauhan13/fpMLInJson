package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ApiClient {

    public void makeAPICall() throws IOException, InterruptedException {
        var client = HttpClient.newHttpClient();
        var clientRequest = new ClientRequest();
        clientRequest.setCorrelationID("123444");
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        String content = "";
        String escapeXml = null;
        try {
            content = Files.readString(Paths.get(loader.getResource("msg-ex55-execution-advice-trade-partial-termination-cancellation-C11-10.xml").toURI()));
            System.out.println("content= " + content);
            //Escaping is not needed as Gson library used escapes it
//            String escapedJson = StringEscapeUtils
//            escapeXml = StringEscapeUtils.escapeXml11(content);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ex= " + e.getMessage());

        }

        clientRequest.setPayload(content);
        String jsonPayload = jsonFromObjUsingJackson(clientRequest);
        var request = HttpRequest.newBuilder(
                        URI.create("http://localhost:8080/trade"))
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

    private String jsonFromObjUsingJackson(Object obj) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(obj);
        return jsonInString;
    }

    private String jsonFromObjUsingGson(Object obj) throws IOException {
                Gson gson = new Gson();
        String jsonInString = gson.toJson(obj);
        return jsonInString;
    }
}
