package oooshit.eventLogger;

import oooshit.other.Event;

import java.util.Collection;


public class CombineEventLogger implements EventLogger {

    private Collection<EventLogger> loggers;

    public CombineEventLogger(Collection<EventLogger> loggers) {
        super();
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        for(EventLogger logger:loggers){
            logger.logEvent(event);
        }
    }

    public Collection<EventLogger> getLoggers() {
        return loggers;
    }
}
