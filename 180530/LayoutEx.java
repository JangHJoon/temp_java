package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class LayoutEx extends JFrame {
	
	public LayoutEx() {
		
		JLabel lbl = new JLabel(
			"this is a JLabel", JLabel.LEFT
		);
		lbl.setFont(
			new Font(Font.DIALOG, Font.BOLD, 30)
		);
		
		EmptyBorder border = new EmptyBorder(
		//  ��, ��, �Ʒ�, ������
			0, 10, 0, 0
		);
		lbl.setBorder(border);
		
		add(lbl, BorderLayout.CENTER);
		
		showFrame();
	}
	private void showFrame() {
		setTitle("LayoutEx");
		//setSize(400, 300);
		pack();
		// ������ ���� �Ŀ� ����� ��
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new LayoutEx();
	}
}






















