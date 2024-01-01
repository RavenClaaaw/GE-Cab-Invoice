package invoice;

public class Invoice implements Comparable<Invoice> {
    public int totalRides;
    public double totalFare;
    public double averageFare;

    public Invoice(int totalRides, double totalFare, double averageFare){
        this.totalRides = totalRides;
        this.totalFare = totalFare;
        this.averageFare = averageFare;
    }

    @Override
    public int compareTo(Invoice other) {
        if(this.totalRides == other.totalRides && this.totalFare == other.totalFare && this.averageFare == other.averageFare) return 0;
        else return 1;
    }
}

