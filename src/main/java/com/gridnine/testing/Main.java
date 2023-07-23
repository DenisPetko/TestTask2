package com.gridnine.testing;

import com.gridnine.testing.filter.FilterArrivalDateEarlierDepartureDate;
import com.gridnine.testing.filter.FilterDepartureToTheCurrentTime;
import com.gridnine.testing.filter.FilterTotalTimeSpentOnEarthExceedsTwoHours;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.FlightBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flightList = FlightBuilder.createFlights();
        System.out.println("All flights:");
        for (Flight flight : flightList) {
            System.out.println(flight);
        }

        System.out.println("Departure to the current time:");
        System.out.println(new FilterDepartureToTheCurrentTime().filter(flightList));

        System.out.println("Arrival date earlier departure date:");
        System.out.println(new FilterArrivalDateEarlierDepartureDate().filter(flightList));

        System.out.println("Total time spent on earth exceeds two hours:");
        System.out.println(new FilterTotalTimeSpentOnEarthExceedsTwoHours().filter(flightList));
    }
}