package ex06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Printer {
		/*
		 * @Autowired -> 타입을 자동주입명령
		 * := 타입으로 찾는다
		 * 
		 * 생성자, 세터, 멤버변수에 적용 가능
		 * 
		 * required = false는
		 * 스프링이 주입할 빈이 없으면 에러를 발생시키는데,
		 * 이를 무시하고 넘어가는 속성. (단, 기본 생성자가 반드시 필요)
		 * 
		 * 
		 * @Qualifier
		 * 컨테이너에서 동일 객체가 여러개 있을 때, 어느 객체를 주입할지 선택해주는 어노테이션
		 * 
		 * 
		 * 
		 * 
		 * 이 셋은 멤버변수에 가장 많이 표현한다
		 */
	@Autowired(required = false)
	@Qualifier("doc1")
	private Document document;
	
	//기본생성자
	public Printer() {
		// TODO Auto-generated constructor stub
	}
	
	//생성자
	public Printer(Document document) {
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
