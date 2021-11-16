package models;

public class Country {
    private String countryName;
    private char countrySign;

    public Country(String countryName, char countrySign) {
        this.countryName = countryName;
        this.countrySign = countrySign;
    }

    public String getCountryInformations() {
        return countryName + " - " + countrySign;
    }
}
