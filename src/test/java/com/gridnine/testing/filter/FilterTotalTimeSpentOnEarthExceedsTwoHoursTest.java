package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.FlightBuilder;
import com.gridnine.testing.model.Segment;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilterTotalTimeSpentOnEarthExceedsTwoHoursTest {
    @Test
    public void whenMoreTwoHours() {
        List<Flight> flightList = FlightBuilder.createFlights();
        List<Flight> flights = new ArrayList<>();
        List<Segment> segmentListTwo = Arrays.asList(
                new Segment(LocalDateTime.now().plusDays(3),
                        LocalDateTime.now().plusDays(3).plusHours(2)),
                new Segment(LocalDateTime.now().plusDays(3).plusHours(5),
                        LocalDateTime.now().plusDays(3).plusHours(6))
        );
        List<Segment> segmentListTree = Arrays.asList(
                new Segment(LocalDateTime.now().plusDays(3).plusHours(0),
                        LocalDateTime.now().plusDays(3).plusHours(2)),
                new Segment(LocalDateTime.now().plusDays(3).plusHours(3),
                        LocalDateTime.now().plusDays(3).plusHours(4)),
                new Segment(LocalDateTime.now().plusDays(3).plusHours(6),
                        LocalDateTime.now().plusDays(3).plusHours(7))
        );

        Flight flight = new Flight(segmentListTwo);
        Flight flight2 = new Flight(segmentListTree);
        flights.add(flight);
        flights.add(flight2);
        assertEquals(new FilterTotalTimeSpentOnEarthExceedsTwoHours().filter(flightList).toString(),
                flights.toString());
    }

    @Test
    public void whenMoreTwoHoursSizeCheck() {
        List<Flight> flightList = FlightBuilder.createFlights();
        List<Flight> flights = new ArrayList<>();
        List<Segment> segmentListTwo = Arrays.asList(
                new Segment(LocalDateTime.now().plusDays(3),
                        LocalDateTime.now().plusDays(3).plusHours(2)),
                new Segment(LocalDateTime.now().plusDays(3).plusHours(5),
                        LocalDateTime.now().plusDays(3).plusHours(6))
        );
        List<Segment> segmentListTree = Arrays.asList(
                new Segment(LocalDateTime.now().plusDays(3).plusHours(0),
                        LocalDateTime.now().plusDays(3).plusHours(2)),
                new Segment(LocalDateTime.now().plusDays(3).plusHours(3),
                        LocalDateTime.now().plusDays(3).plusHours(4)),
                new Segment(LocalDateTime.now().plusDays(3).plusHours(6),
                        LocalDateTime.now().plusDays(3).plusHours(7))
        );

        Flight flight = new Flight(segmentListTwo);
        Flight flight2 = new Flight(segmentListTree);
        flights.add(flight);
        flights.add(flight2);
        assertEquals(new FilterTotalTimeSpentOnEarthExceedsTwoHours().filter(flightList).size(),
                flights.size());
    }

}