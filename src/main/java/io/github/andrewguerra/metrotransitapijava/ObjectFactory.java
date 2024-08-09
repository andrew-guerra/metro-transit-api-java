package io.github.andrewguerra.metrotransitapijava;

import org.json.JSONArray;
import org.json.JSONObject;

public class ObjectFactory {
    @SuppressWarnings("unchecked")
    public static <T> T construct(JSONObject obj, Class<T> type) {
        if(type.equals(Agency.class)) {
            return (T) constructAgency(obj);
        } else if(type.equals(AlertMessage.class)) {
            return (T) constructAlertMessage(obj);
        } else if(type.equals(Departure.class)) {
            return (T) constructDeparture(obj);
        } else if(type.equals(Direction.class)) {
            return (T) constructDirection(obj);
        } else if(type.equals(NexTripResult.class)) {
            return (T) constructNexTripResult(obj);
        } else if(type.equals(Place.class)) {
            return (T) constructPlace(obj);
        } else if(type.equals(ProblemDetails.class)) {
            return (T) constructProblemDetails(obj);
        } else if(type.equals(Route.class)) {
            return (T) constructRoute(obj);
        } else if(type.equals(Stop.class)) {
            return (T) constructStop(obj);
        } else if(type.equals(Vehicle.class)) {
            return (T) constructVehicle(obj);
        } 

        throw new IllegalArgumentException(String.format("%s is not a valid type", type.toString()));
    }

    public static <T> T[] constructArray(JSONArray array, Class<T> type) {
        @SuppressWarnings("unchecked")
        T[] constructedArray = (T[]) new Object[array.length()];

        for(int i = 0; i < array.length(); i++) {
            constructedArray[i] = construct(array.getJSONObject(i), type);
        }

        return constructedArray;
    }

    private static Agency constructAgency(JSONObject obj) {
        return new Agency(obj.getInt("agency_id"),
                          obj.getString("agency_name"));
    }

    private static AlertMessage constructAlertMessage(JSONObject obj) {
        return new AlertMessage(obj.getBoolean("stop_closed"),
                                obj.getString("alert_text"));
    }

    private static Departure constructDeparture(JSONObject obj) {
        return new Departure(obj.getBoolean("actual"),
                             obj.getInt("trip_id"),
                             obj.getInt("stop_id"),
                             obj.getString("depature_text"),
                             obj.getInt("depature_time"),
                             obj.getString("description"),
                             obj.getString("gate"),
                             obj.getString("route_id"),
                             obj.getString("route_short_name"),
                             obj.getInt("direction_id"),
                             obj.getString("direction_text"),
                             obj.getString("terminal"),
                             obj.getString("schedule_relationship"));
    }

    private static Direction constructDirection(JSONObject obj) {
        return new Direction(obj.getInt("direction_id"),
                             obj.getString("direction_name"));
    }

    private static NexTripResult constructNexTripResult(JSONObject obj) {
        return new NexTripResult(constructArray(obj.getJSONArray("stops"), Stop.class),
                                 constructArray(obj.getJSONArray("alerts"), AlertMessage.class),
                                 constructArray(obj.getJSONArray("departures"), Departure.class));
    }

    private static Place constructPlace(JSONObject obj) {
        return new Place(obj.getString("place_code"),
                         obj.getString("description"));
    }

    private static ProblemDetails constructProblemDetails(JSONObject obj) {
        return new ProblemDetails(obj.getString("type"),
                                  obj.getString("title"),
                                  obj.getInt("status"),
                                  obj.getString("detail"),
                                  obj.getString("instance"));
    }

    private static Route constructRoute(JSONObject obj) {
        return new Route(obj.getInt("route_id"),
                         obj.getInt("agency_id"),
                         obj.getString("route_label"));
    }

    private static Stop constructStop(JSONObject obj) {
        return new Stop(obj.getInt("stop_id"),
                        obj.getDouble("latitude"),
                        obj.getDouble("longitude"),
                        obj.getString("description"));
    }

    private static Vehicle constructVehicle(JSONObject obj) {
        return new Vehicle(obj.getString("trip"),
                           obj.getInt("direction_id"),
                           obj.getString("direction"),
                           obj.getInt("location_time"),
                           obj.getString("route_id"),
                           obj.getString("terminal"),
                           obj.getFloat("latitude"),
                           obj.getFloat("longitude"),
                           obj.getFloat("bearing"),
                           obj.getDouble("odometer"),
                           obj.getFloat("speed"));
    }
}
