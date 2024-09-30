package com.study.naumen.homework2.task4;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Task4 {
    public static void main(String[] args) {
        try (HttpClient client = HttpClient.newHttpClient())
        {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/user-agent"))
                    .build();
            HttpResponse<String> jsonResponse = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            ObjectMapper objectMapper = new ObjectMapper();
            UserAgent response = objectMapper.readValue(jsonResponse.body(), UserAgent.class);
            System.out.println(response.userAgent);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
    static class UserAgent {
        @JsonProperty("user-agent")
        String userAgent;
    }
}