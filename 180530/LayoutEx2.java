//package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class LayoutEx2 extends JFrame {

	public LayoutEx2() {
		JPanel pnl = new JPanel(new GridLayout(2, 1));
		
		pnl.add(new JLabel("hello", JLabel.LEFT));
		pnl.add(new JLabel("good night", JLabel.LEFT));
		
		pnl.setBorder(
			new EmptyBorder(0, 20, 0, 0)
		);
		
		add(pnl, BorderLayout.CENTER);
		
		setTitle("여백주기~");
		setSize(300, 200);
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new LayoutEx2();
	}
}









