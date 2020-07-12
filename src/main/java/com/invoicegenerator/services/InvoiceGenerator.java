package com.invoicegenerator.services;

import com.invoicegenerator.models.Ride;
import com.invoicegenerator.utility.RideRepository;
import com.invoicegenerator.utility.RideType;

import java.util.Arrays;

public class InvoiceGenerator {
      private RideRepository rideRepository;
      public InvoiceGenerator() {
            this.rideRepository = new RideRepository();
      }

      public double calculateFare(RideType rideType, double distance, int time) {
            double totalFare = distance * rideType.minimumCostPerKM + time * rideType.costPerTime;
            return Math.max(totalFare, rideType.minFare);
      }

      public InvoiceSummary calculateFare(Ride[] rides) {
            double totalFare = Arrays.stream(rides)
                               .mapToDouble(ride -> this.calculateFare(ride.rideType, ride.distance, ride.time))
                               .sum();
            return new InvoiceSummary(rides.length, totalFare);
      }

      public void addRides(String userId, Ride[] rides) {
            rideRepository.addRide(userId, rides);
      }

      public InvoiceSummary getInvoiceSummary(String userId) {
            return this.calculateFare(rideRepository.getRides(userId));
      }
}