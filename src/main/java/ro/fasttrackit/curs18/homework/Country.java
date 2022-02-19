package ro.fasttrackit.curs18.homework;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static ro.fasttrackit.curs18.homework.StringUtils.*;

public class Country {
    private final int id;
    private final String name;
    private final String capital;
    private final int population;
    private final int area;
    private final String continent;
    private final List<String> neighbours = new ArrayList<>();

    public Country(int id, String name, String capital, int population, int area, String continent, List<String> neighbours){
        this.id = validValue(id);
        this.name = ensureNotEmpty(name);
        this.capital = ensureNotEmpty(capital);
        this.population = validValue(population);
        this.area = validValue(area);
        this.continent = ensureNotEmpty(continent);
        if (neighbours != null) {
            this.neighbours.addAll(neighbours);
        } else {
            throw new IllegalArgumentException("Null list not accepted");
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public int getPopulation() {
        return population;
    }

    public int getArea() {
        return area;
    }

    public String getContinent() {
        return continent;
    }

    public List<String> getNeighbours() {
        return new ArrayList<>(neighbours);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return id == country.id && population == country.population && area == country.area && Objects.equals(name, country.name) && Objects.equals(capital, country.capital) && Objects.equals(continent, country.continent) && Objects.equals(neighbours, country.neighbours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, capital, population, area, continent, neighbours);
    }

    @Override
    public String

    toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                ", area=" + area +
                ", continent='" + continent + '\'' +
                ", neighbours=" + neighbours +
                '}';
    }
}

