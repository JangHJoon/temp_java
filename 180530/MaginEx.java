//package kr.ac.green;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MaginEx extends JFrame {
	
	public MaginEx(){
		JButton btn = new JButton("Button");
		btn.setFont(
			new Font(Font.DIALOG, Font.BOLD, 30)
		);
		
		
		//btn.setMargin(new Insets(40, 40, 40, 40));
		
		setLayout(new FlowLayout());
		add(btn);
		setTitle("Magin Test");
		setLocation(100, 0);
		setSize(400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		System.out.println(btn.getMargin());
	}
	
	public static void main(String[] args) {
		new MaginEx();
	}
}








