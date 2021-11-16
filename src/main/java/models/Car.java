package models;

import enums.CarSegment;

public class Car {
    private Producer producer;
    private boolean isAutomatic;
    private Market market;
    private CarSegment carSegment;
    private Dimension dimension;

    public Car(Producer producer, boolean isAutomatic, Market market, CarSegment carSegment, Dimension dimension) {
        this.producer = producer;
        this.isAutomatic = isAutomatic;
        this.market = market;
        this.carSegment = carSegment;
        this.dimension = dimension;
    }

    public void printCarInformation() {
        System.out.println("\nCar " + producer.getModel() + " with markets:");
        market.getAllCountriesInformations();
    }

    public boolean isCarMeetsTheConditions(String producer, boolean isAutomatic, int trunkCapacity) {
        return (producer.equals(this.producer.getModel()) && this.isAutomatic == isAutomatic && this.dimension.getTrunkCapacity() > trunkCapacity);
    }
}