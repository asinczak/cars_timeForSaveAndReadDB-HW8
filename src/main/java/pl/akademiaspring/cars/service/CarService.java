package pl.akademiaspring.cars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class CarService {

    private RestTemplate restTemplate;

    @Autowired
    public CarService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public void downloadCars(){
        String url = "https://api.mockaroo.com/api/f1177820?count=1000&key=51e23310";
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
//        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET, null, byte[].class);
    }
}
