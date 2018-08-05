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
		// Component �ʱ�ȭ
		init();
		// ��ġ
		setDisplay();
		// ����(EventSource, EventListener)
		addListeners();
		// ������ ����, �����ֱ�
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
	// EventSource, EventListener ����
	private void addListeners() {
	//  �̺�Ʈ�ҽ�.add�����Ҹ�����(�����ʰ�ü)	
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
		// 1. lblNum�� ���� �����´�.
		String value = lblNum.getText();
		// 2. String -> int
		int num = Integer.parseInt(value);
		// 3. 1����
		num++;
		// 4. int -> String
		value = String.valueOf(num);
		// 5. lblNum�� �ݿ�
		lblNum.setText(value);
	}
	
	public static void main(String[] args) {
		new Counter2();
	}

}






