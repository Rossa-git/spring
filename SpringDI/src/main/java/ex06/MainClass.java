package ex06;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

		public static void main(String[] args) {
			
			GenericXmlApplicationContext ctx = 
					new GenericXmlApplicationContext("autowired-context.xml");

				Printer pt = (Printer)ctx.getBean("printer");
				System.out.println(pt.getDocument().data);
			
				
				//---------------------
				Printer2 pt2 = (Printer2)ctx.getBean("printer2");
				System.out.println(pt2.getDocument().data);
			
		}
	
}
