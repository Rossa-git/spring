package ex04;

public class Car {
	
	private IBattery battery;

	//생성자주입
	public Car(IBattery battery) {
		this.battery = battery;
	}

	public IBattery getBattery() {
		return battery;
	}
	
	
}
