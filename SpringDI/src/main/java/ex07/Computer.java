package ex07;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class Computer {

	@Autowired(required = false)
	private Mouse mouse;
	
	@Autowired(required = false)
	private Keyboard kb;
	
	@Autowired(required = false)
	private Monitor monitor;
	
	public void computerInfo() {
		System.out.println("***컴퓨터 정보***");
		mouse.info();
		kb.info();
		monitor.info();
	}
	
	
	
	
	
	
	
	
}
