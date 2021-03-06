package ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {

//		SpringTest t = new SpringTest();
//		t.test();
		
//		ioc컨테이너의 형태
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("application-context.xml");
		
		SpringTest t = (SpringTest)ctx.getBean("test");
		t.test();
		
		SpringTest t2 = (SpringTest)ctx.getBean("test");
		t2.test();
		
		//아무 속성을 적지 않으면 자동으로 싱글톤
		System.out.println(t == t2); 
		//true = t와 t2는 같은 객체다
		//false = t와 t2는 다른 객체다
	}
	
}
