package oooshit;

import oooshit.eventLogger.EventLogger;
import oooshit.other.Event;
import oooshit.other.EventType;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {
        private EventLogger defaultLogger;
        private  Map<EventType, EventLogger> loggers;
        private Client client;


    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
        this.client = client;
    }

    public static void main(String[] args) {

        //app.client = new Client("1","John Smith");
        //app.eventLogger = new ConsoleEventLogger();

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("App");
        Event event = (Event) context.getBean("Event");

        app.logEvent(EventType.INFO,event,"Some event for user 1");

        context.close();

       // app.logEvent("Some event for user 1");
       // app1.logEvent("Some event for user 2");
    }

    public void logEvent(EventType eventType, Event event, String msg){
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);

        EventLogger logger = loggers.get(eventType);
        if (logger == null) {
            logger = defaultLogger;
        }
        logger.logEvent(event);
    }
}
