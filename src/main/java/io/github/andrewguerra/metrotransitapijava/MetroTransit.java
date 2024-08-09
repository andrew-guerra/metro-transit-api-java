package io.github.andrewguerra.metrotransitapijava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class MetroTransit {

    private static String API_SOURCE = "https://svc.metrotransit.org";
    public static void main(String[] args) {
        Agency[] agencies = getAgencies();
        Route[] routes = getRoutes(agencies[0]);

        for (Route route : routes) {
            System.out.println(route.label);
        }
    }

    public static Agency[] getAgencies() {
        JSONArray jsonArray = (JSONArray) makeRequest(APIRoutes.AGENCIES, JSONType.ARRAY);
        
        return ObjectFactory.constructArray(jsonArray, Agency.class);
    }

    public static Route[] getRoutes() {
        JSONArray jsonArray = (JSONArray) makeRequest(APIRoutes.ROUTES, JSONType.ARRAY);

        return ObjectFactory.constructArray(jsonArray, Route.class);
    }

    public static Route[] getRoutes(Agency agency) {
        Route[] allRoutes = getRoutes();
        ArrayList<Route> routesInAgency = new ArrayList<>();

        for(Route route : allRoutes) {
            if(route.agencyID == agency.ID) {
                routesInAgency.add(route);
            }
        }

        Route[] routes = new Route[routesInAgency.size()];
        return routesInAgency.toArray(routes);
    }

    public static NexTripResult[] getStopData(Stop stop) {
        JSONArray jsonArray = (JSONArray) makeRequest(String.format(APIRoutes.STOP_DATA, stop.ID), JSONType.ARRAY);
        
        return ObjectFactory.constructArray(jsonArray, NexTripResult.class);
    }

    public static NexTripResult[] getPlaceData(Route route, Direction direction, Place place) {
        JSONArray jsonArray = (JSONArray) makeRequest(String.format(APIRoutes.PLACE_DATA, route.ID, direction.ID, place.code), JSONType.ARRAY);
        
        return ObjectFactory.constructArray(jsonArray, NexTripResult.class);
    }

    public static Direction[] getDirectionsOnRoute(Route route) {
        JSONArray jsonArray = (JSONArray) makeRequest(String.format(APIRoutes.DIRECTIONS_ON_ROUTE, route.ID), JSONType.ARRAY);

        return ObjectFactory.constructArray(jsonArray, Direction.class);
    }

    public static Place[] getPlacesOnRouteInDirection(Route route, Direction direction) {
        JSONArray jsonArray = (JSONArray) makeRequest(String.format(APIRoutes.PLACES_ON_ROUTE_IN_DIRECTION, route.ID, direction.ID), JSONType.ARRAY);

        return ObjectFactory.constructArray(jsonArray, Place.class);
    }

    public static Vehicle[] getVehiclesOnRoute(Route route) {
        JSONArray jsonArray = (JSONArray) makeRequest(String.format(APIRoutes.VEHICLES_ON_ROUTE, route.ID), JSONType.ARRAY);

        return ObjectFactory.constructArray(jsonArray, Vehicle.class);
    }

    private static enum JSONType {
        OBJECT,
        ARRAY
    }

    private static Object makeRequest(String urlStr, JSONType type) {
        URL url = null;
        try {
            url = new URI(String.format("%s%s", API_SOURCE, urlStr)).toURL();
        } catch (MalformedURLException | URISyntaxException e) {
            e.printStackTrace();
            return null;
        }

        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        configureRequest(connection);

        Object content = getReponse(connection, type);
        connection.disconnect();

        return content;
    }

    private static void configureRequest(HttpURLConnection connection) {
        try {
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
    }

    private static Object getReponse(HttpURLConnection connection, JSONType type) {
        BufferedReader input = null;
        StringBuilder content = new StringBuilder();
        try {
            int status = connection.getResponseCode();

            if(status != 200) {
                return null;
            }

            input = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while((line = input.readLine()) != null) {
                content.append(line);
            }

            input.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        
        switch(type) {
            case OBJECT:
                return new JSONObject(content.toString());
            case ARRAY:
                return new JSONArray(content.toString());
            default:
                return new IllegalArgumentException(String.format("%s is not a valid JSON type", type.toString()));
        }
    }
}
