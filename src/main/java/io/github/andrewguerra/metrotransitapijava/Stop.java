package io.github.andrewguerra.metrotransitapijava;

public class Stop {
    public final int ID;
    public final double latitude;
    public final double longitude;
    public final String description;

    public Stop(int ID, double latitude, double longitude, String description) {
        this.ID = ID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
    }
}
