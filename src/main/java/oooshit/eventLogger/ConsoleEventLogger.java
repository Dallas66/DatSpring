package oooshit.eventLogger;

import oooshit.other.Event;

public class ConsoleEventLogger implements EventLogger {

    public void logEvent(Event event) {
        System.out.println(event);
    }
}

