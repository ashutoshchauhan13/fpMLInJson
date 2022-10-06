package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        var scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            String[] userInputCommand = line.split("\\s+");
            System.out.println(userInputCommand);
            try {
                ApiClient apiClient = new ApiClient();
                apiClient.makeAPICall();
            }
             catch (Exception ex) {
                System.out.println("ex1= "+ ex.getMessage());
            }
        }

    }





}