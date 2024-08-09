package io.github.andrewguerra.metrotransitapijava;

public class Departure {
    public final boolean actual;
    public final int tripID;
    public final int stopID;
    public final String text;
    public final int time;
    public final String description;
    public final String gate;
    public final String routeID;
    public final String routeShortName;
    public final int directionID;
    public final String directionText;
    public final String terminal;
    public final String scheduleRelationship;

    public Departure(boolean actual, int tripID, int stopID, String text, int time, String description, String gate, String routeID, String routeShortName, int directionID, String directionText, String terminal, String scheduleRelationship) {
        this.actual = actual;
        this.tripID = tripID;
        this.stopID = stopID;
        this.text = text;
        this.time = time;
        this.description = description;
        this.gate = gate;
        this.routeID = routeID;
        this.routeShortName = routeShortName;
        this.directionID = directionID;
        this.directionText = directionText;
        this.terminal = terminal;
        this.scheduleRelationship = scheduleRelationship;
    }
}
