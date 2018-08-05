//package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LayoutEx3 extends JFrame {
	
	public LayoutEx3() {
		
		JLabel lblName = new JLabel("name", JLabel.LEFT);
		JLabel lblAddr = new JLabel("address", JLabel.LEFT);
		
		Dimension lblSize = new Dimension(80, 25);
		
		lblName.setPreferredSize(lblSize);
		lblAddr.setPreferredSize(lblSize);		
		
		int inputSize = 10;
		
		JPanel pnlName = new JPanel(
			new FlowLayout(FlowLayout.LEFT)
		);
		pnlName.add(lblName);
		pnlName.add(new JTextField(inputSize));
		
		JPanel pnlAddr = new JPanel(
			new FlowLayout(FlowLayout.LEFT)
		);
		pnlAddr.add(lblAddr);
		pnlAddr.add(new JTextField(inputSize));
		
		JPanel pnlCenter = new JPanel(
			new GridLayout(0, 1)
		);
		
		pnlCenter.add(pnlName);
		pnlCenter.add(pnlAddr);
		
		add(pnlCenter, BorderLayout.CENTER);
		
		JPanel pnlBtns = new JPanel();
		
		JButton btn1 = new JButton("button");
		JButton btn2 = new JButton("etc");
		
		Dimension btnSize = new Dimension(80, 25);
		btn1.setPreferredSize(btnSize);
		btn2.setPreferredSize(btnSize);
		
		
		pnlBtns.add(btn1);
		pnlBtns.add(btn2);
		
		add(pnlBtns, BorderLayout.SOUTH);
		
		setTitle("사이즈 조절~");
		pack();
		// setSize(500, 400);
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new LayoutEx3();
	}
}
