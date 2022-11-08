package com.hvs.lab.service.implementations;

import com.hvs.lab.service.contracts.IWebsiteReaderService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebsiteReaderService implements IWebsiteReaderService {

    private final RestTemplate restTemplate;

    public WebsiteReaderService(){
        this.restTemplate = new RestTemplate();
    }

    @Override
    public String readWebsite(String url) {
        return this.restTemplate.getForObject(url, String.class);
    }
}
