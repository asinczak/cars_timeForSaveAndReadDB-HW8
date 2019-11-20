package pl.akademiaspring.cars.service;


import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

@Service
public class DownloadFile {

    private final static String PATH_NAME = "src/main/resources/templates/cars.csv";
    private final static String URL = "https://api.mockaroo.com/api/f1177820?count=1000&key=51e23310";
    private RestTemplate restTemplate;

    @Autowired
    public DownloadFile(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void downloadCars() throws IOException {
        if(!checkingIfFileExists()) {
            URL url = new URL(URL);
            File file = new File(PATH_NAME);

            FileUtils.copyURLToFile(url, file);
        }

    }

    public boolean checkingIfFileExists(){
        Path path = Paths.get(PATH_NAME);
        if (Files.exists(path)) {
            return true;
        } else {
            return false;
        }
    }
}
