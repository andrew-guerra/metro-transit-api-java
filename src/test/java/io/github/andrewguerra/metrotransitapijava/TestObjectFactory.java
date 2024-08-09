package io.github.andrewguerra.metrotransitapijava;

import static org.junit.Assert.assertEquals;

import org.json.JSONObject;
import org.junit.Test;

public class TestObjectFactory {
    private final JSONObject AGENCY = new JSONObject("{agency_id: 0, agency_name: \"name\"}");
    private final JSONObject ALERT_MESSAGE = new JSONObject("{stop_closed: true, alert_text: \"text\"}");
    private final JSONObject DEPARTURE = new JSONObject("{actual: true, trip_id: 0, stop_id: 0, depature_text: \"text\", depature_time: 0, description: \"description\", gate: \"gate\", route_id: \"id\", route_short_name: \"short\", direction_id: 0, direction_text: \"text\", terminal: \"terminal\", schedule_relationship: \"relationship\"}");
    private final JSONObject DIRECTION = new JSONObject("{direction_id: 0, direction_name: \"name\"}");
    private final JSONObject PLACE = new JSONObject("{place_code: \"code\", description: \"description\"}");
    private final JSONObject PROBLEM_DETAILS = new JSONObject("{type: \"type\", title: \"title\", status: 0, detail: \"detail\", instance: \"instance\"}");
    private final JSONObject ROUTE = new JSONObject("{route_id: 0, agency_id: 0, route_label: \"label\"}");
    private final JSONObject STOP = new JSONObject("{stop_id: 0, latitude: 0, longitude: 0, description: \"description\"}");
    private final JSONObject VEHICLE = new JSONObject("{trip: \"trip\", direction_id: 0, direction: \"direction\", location_time: 0, route_id: \"id\", terminal: \"terminal\", latitude: 0, longitude: 0, bearing: 0, odometer: 0, speed: 0}");
    private final JSONObject NEXTRIP_RESULT = new JSONObject(String.format("{stops: [%s], alerts: [%s], departures: [%s]}", STOP.toString(), ALERT_MESSAGE.toString(), DEPARTURE.toString()));

    @Test
    public void testConstructAgency() {
        Agency agency = ObjectFactory.construct(AGENCY, Agency.class);

        assertEquals(AGENCY.getInt("agency_id"), agency.ID);
        assertEquals(AGENCY.getString("agency_name"), agency.name);
    }

    @Test
    public void testConstructAlertMessage() {
        AlertMessage alertMessage = ObjectFactory.construct(ALERT_MESSAGE, AlertMessage.class);

        assertEquals(ALERT_MESSAGE.getBoolean("stop_closed"), alertMessage.stopClosed);
        assertEquals(ALERT_MESSAGE.getString("alert_text"), alertMessage.text);
    }

    @Test
    public void testConstructDeparture() {
        Departure departure = ObjectFactory.construct(DEPARTURE, Departure.class);

        assertEquals(DEPARTURE.getBoolean("actual"), departure.actual);
        assertEquals(DEPARTURE.getInt("trip_id"), departure.tripID);
        assertEquals(DEPARTURE.getInt("stop_id"), departure.stopID);
        assertEquals(DEPARTURE.getString("depature_text"), departure.text);
        assertEquals(DEPARTURE.getInt("depature_time"), departure.time);
        assertEquals(DEPARTURE.getString("description"), departure.description);
        assertEquals(DEPARTURE.getString("gate"), departure.gate);
        assertEquals(DEPARTURE.getString("route_id"), departure.routeID);
        assertEquals(DEPARTURE.getString("route_short_name"), departure.routeShortName);
        assertEquals(DEPARTURE.getInt("direction_id"), departure.directionID);
        assertEquals(DEPARTURE.getString("direction_text"), departure.directionText);
        assertEquals(DEPARTURE.getString("terminal"), departure.terminal);
        assertEquals(DEPARTURE.getString("schedule_relationship"), departure.scheduleRelationship);
    }

    @Test
    public void testConstructDirection() {
        Direction direction = ObjectFactory.construct(DIRECTION, Direction.class);

        assertEquals(DIRECTION.getInt("direction_id"), direction.ID);
        assertEquals(DIRECTION.getString("direction_name"), direction.name);
    }

    @Test
    public void testConstructNexTripResult() {
        //NexTripResult nexTripResult = ObjectFactory.construct(NEXTRIP_RESULT, NexTripResult.class);
    }

    @Test
    public void testConstructPlace() {
        Place place = ObjectFactory.construct(PLACE, Place.class);

        assertEquals(PLACE.getString("place_code"), place.code);
        assertEquals(PLACE.getString("description"), place.description);
    }

    @Test
    public void testConstructProblemDetails() {
        ProblemDetails problemDetails = ObjectFactory.construct(PROBLEM_DETAILS, ProblemDetails.class);

        assertEquals(PROBLEM_DETAILS.getString("type"), problemDetails.type);
        assertEquals(PROBLEM_DETAILS.getString("title"), problemDetails.title);
        assertEquals(PROBLEM_DETAILS.getInt("status"), problemDetails.status);
        assertEquals(PROBLEM_DETAILS.getString("detail"), problemDetails.detail);
        assertEquals(PROBLEM_DETAILS.getString("instance"), problemDetails.instance);
    }

    @Test
    public void testConstructRoute() {
        Route route = ObjectFactory.construct(ROUTE, Route.class);

        assertEquals(ROUTE.getInt("route_id"), route.ID);
        assertEquals(ROUTE.getInt("agency_id"), route.agencyID);
        assertEquals(ROUTE.getString("route_label"), route.label);
    }

    @Test
    public void testConstructStop() {
        Stop stop = ObjectFactory.construct(STOP, Stop.class);

        assertEquals(STOP.getInt("stop_id"), stop.ID);
        assertEquals(STOP.getDouble("latitude"), stop.latitude, 0.001);
        assertEquals(STOP.getDouble("longitude"), stop.longitude, 0.001);
        assertEquals(STOP.getString("description"), stop.description);
    }

    @Test
    public void testConstructVehicle() {
        Vehicle vehicle = ObjectFactory.construct(VEHICLE, Vehicle.class);

        assertEquals(VEHICLE.getString("trip"), vehicle.ID);
        assertEquals(VEHICLE.getInt("direction_id"), vehicle.directionID);
        assertEquals(VEHICLE.getString("direction"), vehicle.direction);
        assertEquals(VEHICLE.getInt("location_time"), vehicle.locationTime);
        assertEquals(VEHICLE.getString("route_id"), vehicle.routeID);
        assertEquals(VEHICLE.getString("terminal"), vehicle.terminal);
        assertEquals(VEHICLE.getFloat("latitude"), vehicle.latitude, 0.001);
        assertEquals(VEHICLE.getFloat("longitude"), vehicle.longitude, 0.001);
        assertEquals(VEHICLE.getFloat("bearing"), vehicle.bearing, 0.001);
        assertEquals(VEHICLE.getDouble("odometer"), vehicle.odometer, 0.001);
        assertEquals(VEHICLE.getFloat("speed"), vehicle.speed, 0.001);
    }
}
