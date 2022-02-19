package ro.fasttrackit.curs18.homework;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //controller-ul face leg cu web-ul

public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    List<Country> listAllCountries() {
        return countryService.listAllCountries();
    }

    @GetMapping("/countries/names")
    List<String> listAllCountriesNames() {
        return countryService.listAllCountriesNames();
    }

    @GetMapping("/countries/{countryId}/capital")
    String getCapital(@PathVariable int countryId) {
        return countryService.getCapitalOfACountry(countryId);
    }

    @GetMapping("/countries/{countryId}/population")
    int getPopulation (@PathVariable int countryId) {
        return countryService.getPopulationOfACountry(countryId);
    }

    @GetMapping("/continents/{continentName}/countries")
    List<Country> getCountriesInContinent(@PathVariable String continentName) {
        return countryService.getCountriesInContinent(continentName);
    }

    @GetMapping("/countries/{countryId}/neighbours")
    List<String> getCountryNeighbours(@PathVariable int countryId) {
        return  countryService.getCountryNeighbours(countryId);
    }

    @GetMapping("/continents/{continentName}/countries")
    List<Country> getCountriesByContinentWithMinPop(@PathVariable String continentName, //mai static
                                                    @RequestParam int minPopulation) { //mai variabil
        return countryService.getCountriesInContinentWithMinPopulation(continentName, minPopulation);
    }

    @GetMapping("/countries")
    List<Country> getCountriesWithNeighbourXButNotY(@RequestParam String neighbourX,
                                                    @RequestParam String neighbourY) {
        return countryService.getCountriesThatHaveNeighbourXButNotY(neighbourX, neighbourY);
    }

}
