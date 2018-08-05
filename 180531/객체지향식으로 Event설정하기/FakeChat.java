package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FakeChat extends JFrame 
	implements ActionListener {
	
	private JTextArea taOutput;
	private JTextField tfInput;
	private JButton btnSend;
	
	public FakeChat() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
//	component 초기화
	private void init() {
		taOutput = new JTextArea();
		taOutput.setEditable(false);
		
		tfInput = new JTextField(20);
		btnSend = new JButton("보내기");		
	}
//	배치
	private void setDisplay() {
		JScrollPane scroll = new JScrollPane(taOutput);
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(tfInput);
		pnlSouth.add(btnSend);
		
		add(scroll, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	private void addListeners() {
		btnSend.addActionListener(this);
		tfInput.addActionListener(this);
	}
	
	
//	보여주기(프레임 설정)
	private void showFrame() {
		setTitle("Chat");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		String input = tfInput.getText();
		
		taOutput.append(input + "\n");
		
		// tfInput.setText("");
		tfInput.selectAll();
		tfInput.requestFocus();		
	}
	public static void main(String[] args) {
		new FakeChat();
	}
}















