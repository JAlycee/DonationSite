package com.Jasmineconnect.DonationSite.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public class MailtrapService {

    private static final String API_BASE_URL = "https://mailtrap.io/api/v2";
    private static final String API_TOKEN = "23245968f7140ea91a725a1a5d9fe5ec";

    private final RestTemplate restTemplate;

    public MailtrapService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendEmail(String recipient, String subject, String body) {
        String endpoint = API_BASE_URL + "/inboxes/INBOX_ID/messages";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Api-Token", API_TOKEN);

        // Build the request body
        String requestBody = "{"
                + "\"message\": {"
                + "\"subject\": \"" + subject + "\","
                + "\"to_email\": \"" + recipient + "\","
                + "\"body\": \"" + body + "\""
                + "}"
                + "}";

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Send the HTTP POST request to Mailtrap API
        ResponseEntity<String> response = restTemplate.exchange(endpoint, HttpMethod.POST, requestEntity, String.class);

        // Handle the response, if needed
        if (response.getStatusCode().is2xxSuccessful()) {
            // Email sent successfully
            System.out.println("Email sent successfully");
        } else {
            // Error handling
            System.err.println("Failed to send email. Response code: " + response.getStatusCode());
            System.err.println("Response body: " + response.getBody());
        }

    }
}
