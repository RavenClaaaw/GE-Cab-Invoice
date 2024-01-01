import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import invoice.Invoice;
import invoice.InvoiceGenerator;
import invoice.Ride;

public class Junit {
    @Test
    public void testLogic(){
        InvoiceGenerator invoice = new InvoiceGenerator();
        Ride ride = new Ride(5,5, false);
        assertEquals(invoice.getCost(ride), 55.0);
    }

    @Test
    public void testMinFare(){
        InvoiceGenerator invoice = new InvoiceGenerator();
        Ride ride = new Ride(0.1, 1, false);
        assertEquals(invoice.getCost(ride), 5);
    }

    @Test
    public void testAggregate(){
        InvoiceGenerator invoice = new InvoiceGenerator();
        Ride rides[] = new Ride[3];
        rides[0] = new Ride(0, 0, false);
        rides[1] = new Ride(10, 20, false);
        rides[2] = new Ride(5, 5, false);

        assertEquals(invoice.getAggregateCost(rides), 180);
    }

    @Test
    public void testEnhancedInvoice(){
        InvoiceGenerator invoice = new InvoiceGenerator();
        Ride rides[] = new Ride[3];
        rides[0] = new Ride(0, 0, false);
        rides[1] = new Ride(10, 20, false);
        rides[2] = new Ride(5, 5, false);

        Invoice result = new Invoice(3, 180, 60);

        assertEquals(invoice.getInvoice(rides).totalRides, 3);
        assertEquals(invoice.getInvoice(rides).totalFare, 180);
        assertEquals(invoice.getInvoice(rides).averageFare, 60);
    }

    @Test
    public void testInvoiceService(){
        InvoiceGenerator invoice = new InvoiceGenerator();
        Ride rides[] = new Ride[3];
        rides[0] = new Ride(0, 0, false);
        rides[1] = new Ride(10, 20, false);
        rides[2] = new Ride(5, 5, false);

        invoice.addUserInvoice("1", rides[0]);
        invoice.addUserInvoice("1", rides[1]);
        invoice.addUserInvoice("1", rides[2]);

        assertEquals(invoice.getUserInvoice("1").size(), 3);
    }

    @Test
    public void testPremium(){
        InvoiceGenerator invoice = new InvoiceGenerator();
        assertEquals(invoice.getCost(new Ride(10, 15, true)), 180);;
    }
}
