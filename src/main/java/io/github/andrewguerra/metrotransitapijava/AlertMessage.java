package io.github.andrewguerra.metrotransitapijava;

public class AlertMessage {
    public final String text;
    public final boolean stopClosed;

    public AlertMessage(boolean stopClosed, String text) {
        this.text = text;
        this.stopClosed = stopClosed;
    }
}
