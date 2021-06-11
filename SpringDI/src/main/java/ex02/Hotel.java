package ex02;

public class Hotel {
	//멤버변수
	private Chef chef;
	
	//생성자
	public Hotel(Chef chef) {
		//chef가 없으면 Hotel은 생성될 수 없다
		this.chef = chef;
	}
	
	//getter
	public Chef getChef() {
		return chef;
	}
}
