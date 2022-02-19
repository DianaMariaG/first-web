package ro.fasttrackit.curs18.homework;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class CountriesReaderFile {
    private final String filePath;

    public CountriesReaderFile (String filepath) {
        this.filePath = filepath;
    }

    public List<Country> getCountryList() throws Exception {
        int count=0;
        List<Country> result = new ArrayList<>();
        try(BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                result.add(readLine(++count, line));
            }
        }
        return result;
    }

    private static Country readLine(int id, String line) {
        String[] tokens = line.split(Pattern.quote("|"));

        List<String> neighbours = new ArrayList<>();
        if (tokens.length == 6) {
            neighbours = Arrays.asList(tokens[5].split(Pattern.quote("~")));
        }
        return new Country(id,tokens[0],tokens[1],Integer.parseInt(tokens[2])
                ,Integer.parseInt(tokens[3]),tokens[4],neighbours);
    }
}

