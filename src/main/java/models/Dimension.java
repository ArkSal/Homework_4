package models;

import java.util.Random;

public class Dimension {
    private int high;
    private int width;
    private int trunkCapacity;

    public Dimension(int high, int width, int trunkCapacity) {
        this.high = high;
        this.width = width;
        this.trunkCapacity = trunkCapacity;
    }

    public int getTrunkCapacity() {
        return trunkCapacity;
    }

    public static int getRandomDimension() {
        return new Random().ints(300, 500).findFirst().getAsInt();
    }

    public static int getRandomTrunkCapacity() {
        return new Random().ints(50, 500).findFirst().getAsInt();
    }

}
