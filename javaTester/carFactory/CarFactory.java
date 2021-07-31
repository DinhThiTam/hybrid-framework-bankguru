package carFactory;

public class CarFactory {
	public void viewCarByType(String carTypeName) {
		if(carTypeName.equalsIgnoreCase("Honda")) {
			Honda honda = new Honda();
			honda.viewCar();
		}else if(carTypeName.equalsIgnoreCase("Toyota")) {
			Toyota toyota = new Toyota();
			toyota.viewCar();
		}else if(carTypeName.equalsIgnoreCase("Kia")) {
			Kia kia = new Kia();
			kia.viewCar();
		}
	}
}
