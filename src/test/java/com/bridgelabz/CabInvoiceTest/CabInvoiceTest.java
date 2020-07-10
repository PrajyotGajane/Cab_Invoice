package com.bridgelabz.CabInvoiceTest;
import com.bridgelabz.CabInvoice.InvoiceGenerator;
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
}
