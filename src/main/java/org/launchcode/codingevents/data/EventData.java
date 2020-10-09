package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {

    //class responsible only for storing event objects, a single point of truth for how event objects are stored
    //all the below are static bc not creating instances, just a collection of methods I can use
    //need a place to put events - data structure of some type
    private static final Map<Integer, Event> events = new HashMap<>(); //type map with key/integer value/event pairs

    //get all events
    public static Collection<Event> getAll() {   //going to return a list of events, Collection is an interface that is iterable
        return events.values();
    }

    //get a single event
    public static Event getById(int id) {
        return events.get(id); //retrieve item w/specific key
    }

    //add an event
    public static void add(Event event) {
        events.put(event.getId(), event);  //key is id and value is event itself
    }

    //delete an event
    public static void remove(int id) {
        events.remove(id);
    }

}
