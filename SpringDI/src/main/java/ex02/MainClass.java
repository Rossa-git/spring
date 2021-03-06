package ex02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
//		Chef c = new Chef();
//		Hotel h = new Hotel(c);
		
		
//		DI 설정 : application-context.xml에서 설정
//		Hotel h = new Hotel(new Chef());
		
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("application-context.xml");
		
		//Hotel은 Chef없이는 생성 될 수 없다 = Hotel은 Chef에게 의존적이다
		Hotel h = (Hotel)ctx.getBean("hotel");
		
		Chef c = h.getChef();
		c.cooking();
		
	}
	
}
