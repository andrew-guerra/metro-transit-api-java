package io.github.andrewguerra.metrotransitapijava;

public class NexTripResult {
    public final Stop[] stops;
    public final AlertMessage[] alerts;
    public final Departure[] departures;

    public NexTripResult(Stop[] stops, AlertMessage[] alerts, Departure[] departures) {
        this.stops = stops;
        this.alerts = alerts;
        this.departures = departures;
    }
}
