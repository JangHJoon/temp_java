package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Answer2 extends JFrame 
	implements IWorker {

	private JLabel lblInput;
	private JTextField tfInput;
	
	private JButton btnCalc;
	
	private JTextField tfResult;
	
	public Answer2() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	private void init() {
		lblInput = new JLabel("거리를 마일단위로 입력하시오");
		tfInput = new JTextField(5);
		btnCalc = new JButton("변환");
		
		tfResult = new JTextField(15);
		
		tfResult.setEditable(false);
		
		tfResult.setBackground(Color.WHITE);
		tfResult.setBorder(new LineBorder(Color.GRAY, 1));
	}

	private void setDisplay() {
		JPanel pnlNorth = new JPanel();
		pnlNorth.add(lblInput);
		pnlNorth.add(tfInput);
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.add(btnCalc);
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(tfResult);
		
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	private void addListeners() {
		btnCalc.addActionListener(
			new MyActionListener3(this)
		);
	}
	private void showFrame() {
		setTitle("마일을 킬로미터로 변환");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 창크기 고정
		setResizable(false);
		setVisible(true);
	}
	@Override
	public void todo() {
		String input = tfInput.getText();
		String msg = "숫자만 입력가능합니다.";
		try {
			int mile = Integer.parseInt(input);
			double km = mile * 1.6;		
			msg = mile + "마일은 " + km + "km입니다.";
		} catch(NumberFormatException e) {	
			JOptionPane.showMessageDialog(
				this, 	// 부모창
				msg, 	// 메세지
				"입력에러", // 타이틀
				JOptionPane.PLAIN_MESSAGE // 아이콘
			);
			/*
			 * JOptionPane.ERROR_MESSAGE
			 * JOptionPane.WARNING_MESSAGE
			 * JOptionPane.INFORMATION_MESSAGE
			 * JOptionPane.QUESTION_MESSAGE
			 * JOptionPane.PLAIN_MESSAGE
			 */
		}
		tfResult.setText(msg);
	}
	public static void main(String[] args) {
		new Answer2();
	}
}















