package io.github.andrewguerra.metrotransitapijava;

public class Route {
    public final int ID;
    public final int agencyID;
    public final String label;

    public Route(int ID, int agencyID, String label) {
        this.ID = ID;
        this.agencyID = agencyID;
        this.label = label;
    }
}
