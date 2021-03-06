package teamproject.savannahpyle.calendarapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to hold a list of events that happen
 * on a specific date.
 */
public class EventList {

    public List<Event> eventList;
    public String date;

    public EventList() {
        eventList = new ArrayList<>();
    }

    public EventList(String date) {
        this.date = date;
        eventList = new ArrayList<>();
    }

    public EventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void add(Event e) {
        eventList.add(e);
    }
}
