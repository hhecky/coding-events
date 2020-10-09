package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping
    public String displayAllEvents(Model model) {  //controller method passes in collection of all events to be displayed
        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        return "events/create";
    }

    @PostMapping("create") //created new event from form submission
    public String processCreateEventForm(@RequestParam String eventName, @RequestParam String eventDescription) {
        EventData.add(new Event(eventName, eventDescription));
        return "redirect:";
    }

    @GetMapping("delete") //allows us to delete events from our application, method to display the form, path is actually /events/delete
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");//title for events
        model.addAttribute("events", EventData.getAll());//pass in collection of events that we can loop over
        return "events/delete"; //renders form
    }

    @PostMapping("delete") //
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) { //eventIds is param name which has to be same as name in form template in delete.html
//required=false means if we don't select anything to delete we'll still be redirected to event listing
        //but we have to protect against null
        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
        return "redirect:"; //returns you back to event listing
    }

}
