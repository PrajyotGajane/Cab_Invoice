package com.bridgelabz.CabInvoice.CabInvoiceTest;
import com.bridgelabz.CabInvoice.CabInvoice.InvoiceGenerator;
import com.bridgelabz.CabInvoice.CabInvoice.InvoiceSummary;
import com.bridgelabz.CabInvoice.CabInvoice.Ride;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class CabInvoiceTest {
       InvoiceGenerator invoiceGenerator;
      @Before
      public void setUp() {
            invoiceGenerator = new InvoiceGenerator();
      }
      @Test
      public void givenDistanceAndTime_ShouldReturnTotalFare() {
            InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
            double distance = 2.0;
            int time = 5;
            double fare = invoiceGenerator.calculateFare(distance, time);
            Assert.assertEquals(25, fare, 0.0);
      }
      @Test
      public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
            double distance = 0.1;
            int time = 1;
            double fare = invoiceGenerator.calculateFare(distance, time);
            Assert.assertEquals(5, fare, 0.0);
      }
      @Test
      public void givenMultipleRides_ShouldReturnInvoiceSummary() {
            Ride[] ride = {new Ride(2.0, 5),
                           new Ride(0.1, 1)};
            InvoiceSummary summary = invoiceGenerator.calculateFare(ride);
            InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
            Assert.assertEquals(expectedInvoiceSummary, summary);

      }
      @Test
      public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
            String userId="Prajyot";
            Ride[] rides = {new Ride(2.0, 5),
                            new Ride(0.1, 1)};
            invoiceGenerator.addRides(userId,rides);
            InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
            InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
            Assert.assertEquals(expectedInvoiceSummary, summary);
      }
}
