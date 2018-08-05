package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// UI작성
public class Counter extends JFrame implements ActionListener {

	private JButton btnPlus;
	private JLabel lblNum;

	public Counter() {
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
		lblNum.setFont(new Font(Font.DIALOG, Font.BOLD, 60));
	}

	private void setDisplay() {
		getContentPane().add(lblNum, BorderLayout.CENTER);
		add(btnPlus, BorderLayout.SOUTH);
	}

	// EventSource, EventListener 연결
	private void addListeners() {
		// 이벤트소스.add연결할리스너(리스너객체)
		btnPlus.addActionListener(this);
	}

	private void showFrame() {
		setTitle("Counter");
		setSize(300, 400);
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	// Listener 구현
	@Override
	public void actionPerformed(ActionEvent ae) {
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
		new Counter();
	}
}
