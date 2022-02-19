package ro.fasttrackit.curs18.homework;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.swing.*;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws Exception {
//        CountriesReaderFile reader = new CountriesReaderFile("src/main/java/ro/fasttrackit/curs18/homework/countries.txt");
//        System.out.println(reader.getCountryList());
        SpringApplication.run(Main.class,args);

    }
    @Bean
     String getPath() {
        return "src/main/resources/countries.txt";
    }
}
