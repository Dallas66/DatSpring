package oooshit.other;

import java.text.DateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Event {

    private static AtomicInteger ID = new AtomicInteger(0);
    private String msg;
    private Date date;
    private DateFormat dateFormat;
    private int id;

    public static boolean isDay(int start, int end) {
        LocalTime time = LocalTime.now();
        return time.getHour() > start && time.getHour() < end;
    }

    public Event(String msg, Date date, int id) {
        this.msg = msg;
        this.date = date;
        this.id = id;
    }

    public Event(Date date, DateFormat dateFormat) {
        this.id=ID.getAndIncrement();
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public static void initAutoId(int id) {
        ID.set(id);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "msg='" + msg + '\'' +
                ", date=" + dateFormat.format(date) +
                ", id=" + id +
                '}';
    }
}
