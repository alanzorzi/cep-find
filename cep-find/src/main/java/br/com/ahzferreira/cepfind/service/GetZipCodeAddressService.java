package br.com.ahzferreira.cepfind.service;

import br.com.ahzferreira.cepfind.model.Address;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetZipCodeAddressService {
    private final RestTemplate restTemplate;
    private final Environment environment;

    public GetZipCodeAddressService(RestTemplateBuilder restTemplate, Environment environment) {
        this.restTemplate = restTemplate.build();
        this.environment = environment;
    }


    public Address getZipCodeAddress(String cep){
        try {
            StringBuilder url = new StringBuilder();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity request = new HttpEntity(headers);
            url.append(this.environment.getProperty("find.address.api.url")).append(cep.replace(".", "").replace("-", "")).append("/json/");

            ResponseEntity<Address> response = this.restTemplate.exchange(url.toString(), HttpMethod.GET, request, Address.class, new Object[0]);

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                Address address = response.getBody();
                return address;
            }
        }catch (Exception exception){
            System.out.println("Error: " + exception);
        }
        return null;
    }
}
