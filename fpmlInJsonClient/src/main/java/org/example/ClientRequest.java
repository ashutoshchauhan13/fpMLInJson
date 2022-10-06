package org.example;

import lombok.Data;

@Data
public class ClientRequest {
    private String correlationID;
    private String payload;
}
