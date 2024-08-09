package io.github.andrewguerra.metrotransitapijava;

public class APIRoutes {
    public static final String AGENCIES = "/nextrip/agencies";
    public static final String ROUTES = "/nextrip/routes";
    public static final String STOP_DATA = "/nextrip/%d";
    public static final String PLACE_DATA = "/nextrip/%s/%d/%s";
    public static final String DIRECTIONS_ON_ROUTE = "/nextrip/directions/%s";
    public static final String PLACES_ON_ROUTE_IN_DIRECTION = "/nextrip/stops/%s/%d";
    public static final String VEHICLES_ON_ROUTE = "/nextrip/vehicles/%s";
}
