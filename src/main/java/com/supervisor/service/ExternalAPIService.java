package com.supervisor.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalAPIService {

	
	private final String FETCH_SUPERVISOR_API_URL = "https://o3m5qixdng.execute-api.us-east-1.amazonaws.com/api/managers";

    private final RestTemplate restTemplate;

    public ExternalAPIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String fetchSupervisorDataFromExternalAPI() {
        return restTemplate.getForObject(FETCH_SUPERVISOR_API_URL, String.class);
    }
}
