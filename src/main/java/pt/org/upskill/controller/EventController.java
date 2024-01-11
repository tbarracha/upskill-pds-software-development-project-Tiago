package pt.org.upskill.controller;

import TiWorks.Events.*;
import pt.org.upskill.domain.Vaccine;

public class EventController {
    public static Event OnVaccineCreatedDry = new Event();
    public static EventTyped<Vaccine> OnVaccineCreated = new EventTyped<>();
}
