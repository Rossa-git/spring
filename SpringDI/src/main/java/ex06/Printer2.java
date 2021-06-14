package ex06;

import javax.annotation.Resource;

public class Printer2 {
	
	/*
	 * 자바 1.8 어노테이션
	 * @Resource -> 이름으로 찾아서 주입 -> 타입으로 찾아서 주입
	 * := 이름으로 찾는다
	 * 
	 * 
	 * Resource의 빈(bean) 객체 강제 연결은 name속성을 이용하면 된다
	 */
	
	@Resource(name="doc2")
	private Document document;
	
	//기본생성자
	public Printer2() {

	}

	//생성자
	public Printer2(Document document) {
		this.document = document;
	}

	//게터세터
	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
	
}
