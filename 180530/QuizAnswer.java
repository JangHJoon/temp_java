package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QuizAnswer extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6511851525226636914L;
	private JLabel lblMoney;
	private JTextField tfMoney;
	private JLabel lblRate;
	private JTextField tfRate;	
	private JButton btnCalc;	
	private JTextField tfResult;
	
	public QuizAnswer() {
		init();
		setDisplay();		
		showFrame();
	}
	
	private void init() {
		lblMoney = new JLabel("원금을 입력하시오", JLabel.LEFT);
		lblRate = new JLabel("이자율을 입력하시오", JLabel.LEFT);
		
		tfMoney = new JTextField(5);
		tfRate = new JTextField(5);
		
		btnCalc = new JButton("변환");
		
		tfResult = new JTextField(15);
		tfResult.setEditable(false);
		tfResult.setBackground(Color.WHITE);
	}

	private void setDisplay() {
		JPanel pnlLeft = new JPanel(new GridLayout(2, 1));

		JPanel pnlMoneyInfo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlMoneyInfo.add(lblMoney);
		JPanel pnlRateInfo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlRateInfo.add(lblRate);
		
		pnlLeft.add(pnlMoneyInfo);
		pnlLeft.add(pnlRateInfo);
          
        //	
	
		JPanel pnlRight = new JPanel(new GridLayout(2, 1));

		JPanel pnlMoney = new JPanel();
		pnlMoney.add(tfMoney);
		JPanel pnlRate = new JPanel();
		pnlRate.add(tfRate);

		pnlRight.add(pnlMoney);
		pnlRight.add(pnlRate);

        // 각 컴퍼넌트를 각 패널에 넣고 다시 패널에 넣음
		// 4개 전체를 GridLayout으로 잡으면 크기가 모두 같아지므로
        // BorderLayout 으로 WEST, CENTER에 GridLayout을 넣는다.
		
		JPanel pnlSouth = new JPanel(new BorderLayout());
		
		JPanel pnlBtn = new JPanel();
		pnlBtn.add(btnCalc);
		JPanel pnlResult = new JPanel();
		pnlResult.add(tfResult);
		
		pnlSouth.add(pnlBtn, BorderLayout.NORTH);
		pnlSouth.add(pnlResult, BorderLayout.CENTER);

		//
		
		add(pnlLeft, BorderLayout.WEST);
		add(pnlRight, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	
	private void showFrame() {
		setTitle("이자 계산기");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new QuizAnswer();
	}
}