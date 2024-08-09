package io.github.andrewguerra.metrotransitapijava;

public class Vehicle {
    public final String ID;
    public final int directionID;
    public final String direction;
    public final int locationTime;
    public final String routeID;
    public final String terminal;
    public final float latitude;
    public final float longitude;
    public final float bearing;
    public final double odometer;
    public final float speed;

    public Vehicle(String ID, int directionID, String direction, int locationTime, String routeID, String terminal, float latitude, float longitude, float bearing, double odometer, float speed) {
        this.ID = ID;
        this.directionID = directionID;
        this.direction = direction;
        this.locationTime = locationTime;
        this.routeID = routeID;
        this.terminal = terminal;
        this.latitude = latitude;
        this.longitude = longitude;
        this.bearing = bearing;
        this.odometer = odometer;
        this.speed = speed;
    } 
}
