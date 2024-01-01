package invoice;

import java.util.ArrayList;
import java.util.HashMap;

public class InvoiceGenerator {
    public final double COST_PER_KM = 10;
    public final double COST_PER_MIN = 1;
    public final double MIN_FARE = 5;

    public final double COST_PER_KM_P = 15;
    public final double COST_PER_MIN_P = 2;
    public final double MIN_FARE_P = 20;

    public HashMap<String, ArrayList<Ride>> invoiceMap;
    public InvoiceGenerator(){
        invoiceMap = new HashMap<>();
    }

    public Invoice getInvoice(Ride rides[]){
        int totalRides = rides.length;
        double totalFare = 0;
        
        for(int i=0; i<rides.length; i++){
            totalFare += getCost(rides[i]);
        }

        double averageFare = 0;
        if(totalRides > 0) averageFare = totalFare / totalRides;
        
        Invoice invoice = new Invoice(totalRides, totalFare, averageFare);
        return invoice;
    }

    public double getAggregateCost(Ride rides[]){
        double total = 0;

        for(int i=0; i<rides.length; i++){
            total += getCost(rides[i]);
        }

        return total;
    }

    public double getCost(Ride ride){
        double distance = ride.distance;
        double time = ride.time;

        if(ride.premium){
            double cost = distance * COST_PER_KM_P + time * COST_PER_MIN_P;
            cost = Math.max(cost, MIN_FARE_P);
            return cost;
        }

        else{
            double cost = distance * COST_PER_KM + time * COST_PER_MIN;
            cost = Math.max(cost, MIN_FARE);
            return cost;
        }
    }

    public void addUserInvoice(String user, Ride ride){
        if(!invoiceMap.containsKey(user)) invoiceMap.put(user, new ArrayList<Ride>());
        invoiceMap.get(user).add(ride);
        return;
    }

    public ArrayList<Ride> getUserInvoice(String user){
        if(invoiceMap.containsKey(user)) return invoiceMap.get(user);
        else return null;
    }
}
