package case_study7;

public class VehicleManagment {
	public static void main(String[] args) {
		Vehicle[] vehicles = {
			new Car("CAR2001",130,5),
			new Car("BIKE3001",80,40.5),
			new Car("Truck5001",30,12)
		};
		for(Vehicle ve:vehicles){
			ve.displayDetails();
			System.out.println();
		}

	}

}
