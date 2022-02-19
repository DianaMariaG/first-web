package ro.fasttrackit.curs18.homework;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {
    private final List<Country> countries = new ArrayList<>();

    public CountryService(CountriesReaderFile countriesReaderFile) throws Exception {
        countries.addAll(countriesReaderFile.getCountryList()); //in lista de countries am adaugat fisierul citit cu reader-ul
    }

    public List<Country> listAllCountries() {
        return countries;
    }

    public List<String> listAllCountriesNames() {
        return countries.stream()
                .map(country -> country.getName())
                .collect(Collectors.toList());
    }

    public String getCapitalOfACountry(int id) {
        List<String> result = countries.stream()
                .filter(country -> country.getId() == id)
                .map(country -> country.getCapital())
                .collect(Collectors.toList());
        if (result.size() != 1) {
            throw new IllegalArgumentException("Only one country should be found for id");
        }
        return result.get(0);
    }

    public int getPopulationOfACountry(int id) {
        List<Integer> result = countries.stream()
                .filter(country -> country.getId() == id)
                .map(country -> country.getPopulation())
                .collect(Collectors.toList());
        if(result.size() != 1) {
            throw new IllegalArgumentException("Only one country should be found for id");
        }
        return result.get(0);
    }

    public List<Country> getCountriesInContinent(String continent) {
        return countries.stream()
                .filter(country -> country.getContinent().equals(continent))
                .collect(Collectors.toList());
    }

    public List<String> getCountryNeighbours(int id) {
        return countries.stream()
                .filter(country -> country.getId() == id)
                .map(country -> country.getNeighbours().toString())
                .collect(Collectors.toList());
    }

    public List<Country> getCountriesInContinentWithMinPopulation(String continent, int minPopulation) {
        return countries.stream()
                .filter(country -> country.getContinent().equals(continent))
                .filter(country -> country.getPopulation() > minPopulation)
                .collect(Collectors.toList());
    }

    public List<Country> getCountriesThatHaveNeighbourXButNotY(String neighbourX, String neighbourY) {
        return countries.stream()
                .filter(country -> country.getNeighbours().contains(neighbourX))
                .filter(country -> !country.getNeighbours().contains(neighbourY))
                .collect(Collectors.toList());
    }

}
