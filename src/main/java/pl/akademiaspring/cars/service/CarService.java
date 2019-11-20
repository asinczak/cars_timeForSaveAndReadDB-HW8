package pl.akademiaspring.cars.service;

import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

@Service
public class CarService {

    private RestTemplate restTemplate;

    @Autowired
    public CarService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void downloadCars(){
        String url = "https://api.mockaroo.com/api/f1177820?count=1000&key=51e23310";

        restTemplate.execute(url, HttpMethod.GET, null, clientHttpResponse -> {
            File fileName = new File("cars");
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(String.valueOf(clientHttpResponse.getBody()));

            writer.close();
//            File ret = File.createTempFile("cars", "tmp");
//            StreamUtils.copy(clientHttpResponse.getBody(), new FileOutputStream(ret));
            System.out.println(fileName.getPath());
            return fileName;
        });


    }
}
