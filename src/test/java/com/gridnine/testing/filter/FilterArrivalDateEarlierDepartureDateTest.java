package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.FlightBuilder;
import com.gridnine.testing.model.Segment;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilterArrivalDateEarlierDepartureDateTest {
    @Test
    public void whenIsArrivalEarlierDeparture() {
        List<Flight> flightList = FlightBuilder.createFlights();
        List<Flight> flights = new ArrayList<>();
        List<Segment> segmentList = List.of(
                new Segment(LocalDateTime.now().plusDays(3),
                        LocalDateTime.now().plusDays(3).minusHours(6))
        );
        Flight flight = new Flight(segmentList);
        flights.add(flight);
        assertEquals(new FilterArrivalDateEarlierDepartureDate().filter(flightList).toString(),
                flights.toString());
    }

    @Test
    public void whenDepartureBeforeCurrentTimeSizeCheck() {
        List<Flight> flightList = FlightBuilder.createFlights();
        List<Flight> flights = new ArrayList<>();
        List<Segment> segmentList = List.of(
                new Segment(LocalDateTime.now().minusDays(3), LocalDateTime.now().plusDays(3))
        );

        Flight flight = new Flight(segmentList);
        List<Flight> outfightList = new FilterArrivalDateEarlierDepartureDate().filter(flightList);
        flights.add(flight);
        assertEquals(outfightList.size(), flights.size());
    }

}