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
		lblInput = new JLabel("�Ÿ��� ���ϴ����� �Է��Ͻÿ�");
		tfInput = new JTextField(5);
		btnCalc = new JButton("��ȯ");
		
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
		setTitle("������ ų�ι��ͷ� ��ȯ");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// âũ�� ����
		setResizable(false);
		setVisible(true);
	}
	@Override
	public void todo() {
		String input = tfInput.getText();
		String msg = "���ڸ� �Է°����մϴ�.";
		try {
			int mile = Integer.parseInt(input);
			double km = mile * 1.6;		
			msg = mile + "������ " + km + "km�Դϴ�.";
		} catch(NumberFormatException e) {	
			JOptionPane.showMessageDialog(
				this, 	// �θ�â
				msg, 	// �޼���
				"�Է¿���", // Ÿ��Ʋ
				JOptionPane.PLAIN_MESSAGE // ������
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















