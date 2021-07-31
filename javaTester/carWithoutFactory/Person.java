package carWithoutFactory;

public class Person {

	public static void main(String[] args) {
		Honda honda = new Honda();
		honda.viewCar();
		honda.driverCar();
		
		Toyota toyota = new Toyota();
		toyota.viewCar();
		toyota.driverCar();
		
		Kia kia = new Kia();
		kia.driverCar();
		kia.viewCar();
	}

}
