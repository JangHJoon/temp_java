package kr.ac.green;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener2 implements ActionListener {
	
	private Counter2 frame;
	
	public MyActionListener2(Counter2 frame) {
		this.frame = frame;
	}
	
	// CTRL + SHIFT + F -> 라인 정렬
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.todo();
	}
}





