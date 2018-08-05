package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Counter2 extends JFrame implements IWorker {
	private JButton btnPlus;
	private JLabel lblNum;
	
	public Counter2() {
		// Component 초기화
		init();
		// 배치
		setDisplay();
		// 연결(EventSource, EventListener)
		addListeners();
		// 프레임 설정, 보여주기
		showFrame();
	}
	private void init() {
		btnPlus = new JButton("Plus");
		lblNum = new JLabel("0", JLabel.CENTER);
		lblNum.setFont(
			new Font(Font.DIALOG, Font.BOLD, 60)
		);
	}
	private void setDisplay() {
		getContentPane().add(lblNum, BorderLayout.CENTER);
		add(btnPlus, BorderLayout.SOUTH);
	}
	// EventSource, EventListener 연결
	private void addListeners() {
	//  이벤트소스.add연결할리스너(리스너객체)	
		btnPlus.addActionListener(
			new MyActionListener3(this)
		);
	}
	
	private void showFrame() {
		setTitle("Counter");
		setSize(300, 400);
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}	
	
	public JLabel getLblNum() {
		return lblNum;
	}
	
	public void todo() {
		// 1. lblNum의 값을 가져온다.
		String value = lblNum.getText();
		// 2. String -> int
		int num = Integer.parseInt(value);
		// 3. 1증가
		num++;
		// 4. int -> String
		value = String.valueOf(num);
		// 5. lblNum에 반영
		lblNum.setText(value);
	}
	
	public static void main(String[] args) {
		new Counter2();
	}

}






