package week5;

import java.awt.event.*; // 이벤트 처리를 위한 패키지
import javax.swing.*;

class MyFrame extends JFrame {
	private JButton button1, button2;
	private JLabel label;
	private int number = 1;

	public MyFrame() {
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("이벤트 예제");
		JPanel panel = new JPanel();
		label = new JLabel("1");
		button1 = new JButton("△");
		button2 = new JButton("▽");
		button1.addActionListener(new MyListener());
		button2.addActionListener(new MyListener());

		panel.add(label);
		panel.add(button1);
		panel.add(button2);

		this.add(panel);
		this.setVisible(true);
	}

	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
//        	 try {
        		 
             if (e.getSource() == button1) {
            	 number+=1;
             }
             else {
            	 number-=1;
             }
             label.setText(Integer.toString(number));            	 
//        	 } catch() {
//        		 continue;
//        	 }
         }
	}
}

// 인터페이스란 ?
// 중간 매개체 역할인 인터페이스.

// 예시 
// 컴퓨터에서 마우스 쓰고 싶다.
// 운영체제는 사용자와 I/O 사이에서 인터페이스 역할을 한다.
// 인터페이스의 용어가 확장되면 플랫폼과 같은 용어들이 등장

// GUI 
// 최상위 컨테이너 JFrame
// 일반 컨테이너 JPanel
// 컴포넌트 여럿-->스스로 공부하는 부분

// 생성자의 역할은 데이터 필드에 대한 초기화

// C는 함수단위
// 객체지향은 객체 단위

// 자바의 기본형과 참조형
// 정수형 실수형 등
// new 연산자 사용은 모두 참조형(또한 객체는 모두 참조형!)

// 접근지정자 4가지 

// 객체 지향 특징3가지
// 1. 캡슐화 --> 객체를 만드는 사람과 사용하는 사람 간의 정보 공개 차이(때문에 데이터 필드의 변수는 기본 private, 못해고
// protected)
// 2. 상속
// 3. 다형성

//======================================================================================
// 5주차 시작(인터페이스) 398pg

// 클래스 내에 생성자호출에서 {}와 그 내용 없이 ;으로 마무리한다면 new 가 불가능
// 인터페이스는 내부에 추상 메소드를 반드시 포함해야한다
// 이때 추상메소드는 몸체({})가 구현해야한다.

// 컨테이너가 컴포넌트의 부모인데 상속관계에서 중요포인트
// 이는 캐릭터별 공격 관계를 예시로 들수있다

// 인터페이스는 new 연산자가 불가하다
// 다만 부모자식 관계일 경우 인터페이스 객체 = new 인터페이스 구현(==상속) 클래스 형식으로는 가능하다.

// 인터페이스는 자료형과 같다.

//410pg부분도 모두 이해하기

// 자바에선 클래스 간 다중상속이 불가하나, 인터페이스는 다중 상속이 가능하다.

// 인터페이스는 usb 같다.

// 인터페이스는 다른말로 약속과 같다

// 자바의 인터페이스는 다중상속의 장점을 보존하기 위해 만든 것

// 인터페이스의 내부는 메서드의 프로토타입만 존재하다
// 인터페이스는 멤버 변수를 가질 수 있지만, 그 변수는 오직 public static final 상수여야만 합니다.(?)

//무명 클래스

// 인터페이스와 관련있는 람다? **설명은 스킵이지만 중요하니 모두 읽어봐야한다.

// 유사한 객체들을 묶어논 것을 패키지라고 한다.
// 그 예로 javax.swing.*에서 swing이 패키지이다

// 이벤트 구동 프로그래밍(454pg)

// C의 경우 main이 끝나면 프로그래밍이 종료
// 자바는 프로그램을 다 읽어도 창이 떠있음-->왜??: 멀티쓰래드라고 한다.
// 사용자의 별개 명령이 있을때 까지 대기
// 이와 관련된 것이 이벤트 구동 프로그래밍

// 자바에선 운영체제의 역할을 JVM이 한다. 

// 인터럽트는 소프트웨어나 하드웨어 모두에서 올 수 있다

// 이벤트 리스너에서 
// 마우스의 움직임= mousemotionlistener
// 마우스 클릭= mouselistener
// 키보드=keylistener

//456pg 이벤트 리스너를 컴포넌트에 등록한다.-->버튼과 기능을 연결해주는 단계
// 이를 button.addActioListener(new MyListener());

/// 책 안에 모든 내용이 있기에 인터넷을 애용하자
// 이르테면 키보드의 리스너가 궁금하면
// keyboard listener라고 검색하면
// keyListener가 뜬다
// 또한 구체적인 행위에 따라 이하 메소드의 내용을 다룰 수 있다
// 만약 사용하지 않는 기능이라면 몸통을 빈채로 놔둔다

// 8장 창만들기와 컴포넌트 넣기
// 

// 10장 기능구현
// 5가지 방법을 모두 숙지해야 한다. 
// 마지막 방법에서 메서드가 하나만 존재한다면, 람다식으로 표현

// 반드시 람다식은 이해해야한다!!!!!!!!!!!!!!!!!!!!!!!!!!!
