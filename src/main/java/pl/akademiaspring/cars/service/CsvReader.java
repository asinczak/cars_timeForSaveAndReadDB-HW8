package pl.akademiaspring.cars.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;

@Service
public class CsvReader {

    public void readCsv(ResponseEntity<byte[]> response){
//        er reader = new CsvReader(new InputStreamReader(response.getBody())) CsvRead
    }
}
