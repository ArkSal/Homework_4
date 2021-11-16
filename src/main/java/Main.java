import enums.CarSegment;
import enums.TransportType;
import models.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Country poland = new Country("Polish-Lithuanian Commonwealth", 'P');
        Country turkmenistan = new Country("Turkmenistan", 'T');
        Country southSudan = new Country("South Sudan", 'S');
        Country mongolEmpire = new Country("Mongol Empire", 'M');
        Country uzbekistan = new Country("Uzbekistan", 'U');
        Country holyRomanEmpire = new Country("Holy Roman Empire", 'H');
        Country ottomanEmpire = new Country("Ottoman Empire", 'O');

        Market medivalTransportMarket = new Market(TransportType.TRANSPORT, new ArrayList<>(List.of(holyRomanEmpire, ottomanEmpire, mongolEmpire)));
        Market modernTimesCargoMarket = new Market(TransportType.CARGO, new ArrayList<>(List.of(southSudan, turkmenistan, uzbekistan)));
        Market businessMarket = new Market(TransportType.BUSINESS, new ArrayList<>(List.of(poland, holyRomanEmpire, ottomanEmpire)));
        Market taxiMarket = new Market(TransportType.TAXI, new ArrayList<>(List.of(turkmenistan, mongolEmpire, uzbekistan)));
        Market busMarket = new Market(TransportType.BUS, new ArrayList<>(List.of(poland, mongolEmpire, holyRomanEmpire, ottomanEmpire)));

        List<Dimension> dimensions = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            dimensions.add(i - 1, new Dimension(Dimension.getRandomDimension(), Dimension.getRandomDimension(),
                    Dimension.getRandomTrunkCapacity()));
        }

        Producer mazdaModel = new Producer("Mazda", "RX5");
        Producer toyotaModel = new Producer("Toyota", "Supra");
        Producer audiModel = new Producer("Audi", "S5");
        Producer bmwModel = new Producer("BMW", "X6");
        Producer ferrariModel = new Producer("Ferrari", "488");
        Producer volkswagenModel = new Producer("Volkswagen", "CC");
        Producer nissanModel = new Producer("Nissan", "Leaf");
        Producer mercedesModel = new Producer("MErcedes", "GLC");
        Producer ssangyongModel = new Producer("SsangyYng", "Rexton");
        Producer mitsubishiModel = new Producer("Mitsubishi", "Lancer");

        Car mazdaTaxi = new Car(mazdaModel, true, taxiMarket, CarSegment.MEDIUM, dimensions.get(0));
        Car toyotaBus = new Car(toyotaModel, false, busMarket, CarSegment.MEDIUM, dimensions.get(1));
        Car audiTaxi = new Car(audiModel, false, taxiMarket, CarSegment.STANDARD, dimensions.get(2));
        Car bmwCargo = new Car(bmwModel, true, modernTimesCargoMarket, CarSegment.PREMIUM, dimensions.get(3));
        Car ferrari = new Car(ferrariModel, true, medivalTransportMarket, CarSegment.PREMIUM, dimensions.get(4));
        Car volkswagen = new Car(volkswagenModel, false, medivalTransportMarket, CarSegment.STANDARD, dimensions.get(5));
        Car nissan = new Car(nissanModel, false, modernTimesCargoMarket, CarSegment.STANDARD, dimensions.get(6));
        Car mercedesBusiness = new Car(mercedesModel, true, businessMarket, CarSegment.PREMIUM, dimensions.get(7));
        Car ssangyong = new Car(ssangyongModel, true, modernTimesCargoMarket, CarSegment.STANDARD, dimensions.get(8));
        Car mitsubishi = new Car(mitsubishiModel, false, busMarket, CarSegment.MEDIUM, dimensions.get(9));
        Car mazdaBussiness = new Car(mazdaModel, true, businessMarket, CarSegment.MEDIUM, dimensions.get(10));
        Car bmwBus = new Car(bmwModel, true, busMarket, CarSegment.PREMIUM, dimensions.get(11));
        Car audiBusiness = new Car(audiModel, false, businessMarket, CarSegment.PREMIUM, dimensions.get(12));
        Car audiTransport = new Car(audiModel, true, medivalTransportMarket, CarSegment.MEDIUM, dimensions.get(13));
        Car mercedesBus = new Car(mercedesModel, true, busMarket, CarSegment.STANDARD, dimensions.get(14));

        List<Car> listOfCars = new ArrayList<>(List.of(mazdaTaxi, toyotaBus, audiTaxi, bmwCargo, ferrari,
                volkswagen, nissan, mercedesBus, mercedesBusiness, ssangyong, mitsubishi,
                mazdaBussiness, bmwBus, audiBusiness, audiTransport));

        getMarketInfosAboutSpecificCars(listOfCars, "BMW", true, 300);
    }

    private static void getMarketInfosAboutSpecificCars(List<Car> listOfCars, String producer, boolean isAutomatic, int trunkCapacity) {
        List<Car> listOfSpecificCars = createListOfSpecificCars(listOfCars, producer, isAutomatic, trunkCapacity);
        if (listOfSpecificCars.isEmpty()) {
            System.out.println("There is no cars with that specific parameters.");
        } else {
            System.out.println("There are cars with specific parameters.");
            for (Car car : listOfSpecificCars) {
                car.printCarInformation();
            }
        }
    }

    private static List<Car> createListOfSpecificCars(List<Car> list, String producer, boolean isAutomatic, int trunkCapacity) {
        List<Car> listOfCarsWithSpecificParameters = new ArrayList<>();
        for (Car car : list) {
            if (car.isCarMeetsTheConditions(producer, isAutomatic, trunkCapacity)) {
                listOfCarsWithSpecificParameters.add(car);
            }
        }
        return listOfCarsWithSpecificParameters;
    }
}


