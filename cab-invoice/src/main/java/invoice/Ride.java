package invoice;

public class Ride {
    public boolean premium;
    public double distance;
    public double time;

    public Ride(double distance, double time, boolean premium){
        this.distance = distance;
        this.time = time;
        this.premium = premium;
    }
}
