package kr.ac.green;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

// alt + shift + t -> n : rename
public class MyActionListener1 implements ActionListener {
	private Counter2 frame;
	public MyActionListener1(Counter2 frame) {
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JLabel lblNum = frame.getLblNum();
				
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
}
