package io.github.andrewguerra.metrotransitapijava;

public class ProblemDetails {
    public final String type;
    public final String title;
    public final int status;
    public final String detail;
    public final String instance;

    public ProblemDetails(String type, String title, int status, String detail, String instance) {
        this.type = type;
        this.title = title;
        this.status = status;
        this.detail = detail;
        this.instance = instance;
    }
}
