package com.gridnine.testing;

import com.gridnine.testing.filter.FilterArrivalDateEarlierDepartureDate;
import com.gridnine.testing.filter.FilterDepartureToTheCurrentTime;
import com.gridnine.testing.filter.FilterTotalTimeSpentOnEarthExceedsTwoHours;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.FlightBuilder;

import java.util.List;

public class Main {
//    Исключите из тестового набора перелёты по следующим правилам
//    (по каждому правилу нужен отдельный вывод списка перелётов):
//    1. Вылет до текущего момента времени
//    2. Сегменты с датой прилёта раньше даты вылета
//    3. Общее время, проведённое на земле превышает два часа

    public static void main(String[] args) {

        List<Flight> flightList = FlightBuilder.createFlights();

        System.out.println("All flights:");
        printFlights(flightList);
        System.out.println("Departure to the current time:");
        System.out.println(new FilterDepartureToTheCurrentTime().filter(flightList));

        System.out.println("All flights:");
        printFlights(flightList);
        System.out.println("Arrival date earlier departure date:");
        System.out.println(new FilterArrivalDateEarlierDepartureDate().filter(flightList));

        System.out.println("All flights:");
        printFlights(flightList);
        System.out.println("Total time spent on earth exceeds two hours:");
        System.out.println(new FilterTotalTimeSpentOnEarthExceedsTwoHours().filter(flightList));
    }

    private static void printFlights(List<Flight> flightList) {
        for (Flight flight : flightList) {
            System.out.println(flight);
        }
    }
}