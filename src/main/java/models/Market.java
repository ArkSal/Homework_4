package models;

import enums.TransportType;

import java.util.ArrayList;
import java.util.List;

public class Market {
    private TransportType name;
    private List<Country> countries;

    public Market(TransportType name, ArrayList<Country> countries) {
        this.name = name;
        this.countries = countries;
    }

    public void getAllCountriesInformations() {
        for (Country country : countries) {
            System.out.println(country.getCountryInformations());
        }
    }

}
