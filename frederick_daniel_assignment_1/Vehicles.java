package frederick_daniel_assignment_1;

public abstract class Vehicles {
    
    private String make; //make (String): Represents the make of the vehicle.
    private String model; //model (String): Represents the model of the vehicle.
    private int year; //year (int): Represents the year of manufacture of the vehicle.

    //Overloaded Contrustor
    public Vehicles(String make, String model, int year) {
        this.make = make; 
        this.model = model;
        this.year = year;
    }

    //Abstract method called getColor:
    abstract String getColor();

    public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

    public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

    public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
