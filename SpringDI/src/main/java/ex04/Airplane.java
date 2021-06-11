package ex04;

public class Airplane {

	private IBattery bettery;

	//setter 주입
	public IBattery getBattery() {
		return bettery;
	}

	public void setBattery(IBattery bettery) {
		this.bettery = bettery;
	}
}
