package frederick_daniel_assignment_1;

public class BMW extends Vehicles {
    private String color;

    public BMW(String make, String model, int year, String color) {
        super(make, model, year);
        this.color = color;
    }

    // getColor method
    public String getColor() {
        return this.color;
    }

    // toString method displaying all data
    public String toString() {
        return "Make:" + getMake() + "\nModel:" + getModel() + "\nYear: " + getYear() + "\nColor: " + getColor();
    }

}
