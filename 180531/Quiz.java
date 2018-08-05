//package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


class Quiz1 extends JFrame{
	
	private JCheckBox chkCombo;
	private JCheckBox chkPotato;
	private JCheckBox chkBulgogi;
	
	private JRadioButton rdPimento;
	private JRadioButton rdCheese;
	private JRadioButton rdPeperoni;
	private JRadioButton rdbacon;
	
	private JCheckBox chkSmall;
	private JCheckBox chkMedium;
	private JCheckBox chkLarge;
		
	private JButton btnOrder;
	private JButton btnCancel;
	
	public Quiz1(){
		init();
		setDisplay();
		showFrame();
	}
	
	private void init(){
		chkCombo = new JCheckBox("콤보");
		chkPotato = new JCheckBox("포테이토");
		chkBulgogi = new JCheckBox("불고기");
				
		rdPimento = new JRadioButton("피망");
		rdCheese = new JRadioButton("치즈");
		rdPeperoni = new JRadioButton("페페로니");
		rdbacon = new JRadioButton("베이컨");
		
		ButtonGroup Topping = new ButtonGroup();
		Topping.add(rdPimento);
		Topping.add(rdCheese);
		Topping.add(rdPeperoni);
		Topping.add(rdbacon);
		
		chkSmall = new JCheckBox("small");
		chkMedium = new JCheckBox("medium");
		chkLarge = new JCheckBox("large");
		
		btnOrder = new JButton("주문");
		btnCancel = new JButton("취소");		
	}
	private void setDisplay(){
		
		JLabel lblNorth = new JLabel("자바피자에 오신것을 환영합니다.",JLabel.CENTER);
		
		//
		
		JPanel pnlCenter = new JPanel(new GridLayout(1,0));
		pnlCenter.setBorder(new EmptyBorder(0, 10, 0, 10));
		
		JPanel pnlSelect1 = new JPanel(new GridLayout(0, 1));
		JPanel pnlSelect2 = new JPanel(new GridLayout(0, 1));
		JPanel pnlSelect3 = new JPanel(new GridLayout(0, 1));
		
		
		
		pnlSelect1.add(chkCombo);
		pnlSelect1.add(chkPotato);
		pnlSelect1.add(chkBulgogi);
		pnlSelect1.setBorder(new TitledBorder("종류"));
		
		pnlSelect2.add(rdPimento);
		pnlSelect2.add(rdCheese);
		pnlSelect2.add(rdPeperoni);
		pnlSelect2.add(rdbacon);
		pnlSelect2.setBorder(new TitledBorder("토핑"));
		
		pnlSelect3.add(chkSmall);
		pnlSelect3.add(chkMedium);
		pnlSelect3.add(chkLarge);
		pnlSelect3.setBorder(new TitledBorder("크기"));
		
		
		pnlCenter.add(pnlSelect1);
		pnlCenter.add(pnlSelect2);
		pnlCenter.add(pnlSelect3);		
		
		//
		
		JPanel pnlSouth = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pnlSouth.add(btnOrder);
		pnlSouth.add(btnCancel);
		
		//
		
		add(lblNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);	
		
	
	}
	private void showFrame(){
		
		setTitle("피자주문");
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	

}


class Quiz2 extends JFrame{
	
	private JTextField tfId;
	private JTextField tfName;
	private JPasswordField pfPassword;
	private JPasswordField pfRePassword;
	
	private JButton btnDoubleCheck;
	
	private JRadioButton rdMale;
	private JRadioButton rdFemale;
	
	private JTextArea taIntro;
	
	private JButton btnJoin;
	private JButton btnCancel;
	
	
	public Quiz2(){
		init();
		setDisplay();
		showFrame();
	}
	
	private void init(){
		
		tfId = new JTextField(15);
		tfName = new JTextField(15);
		pfPassword = new JPasswordField(15);
		pfRePassword = new JPasswordField(15);
		
		btnDoubleCheck = new JButton("중복검사");
		
		rdMale = new JRadioButton("남자",true);
		rdFemale = new JRadioButton("여자");
		
		ButtonGroup groupGender = new ButtonGroup();
		groupGender.add(rdMale);
		groupGender.add(rdFemale);
		
		taIntro = new JTextArea(5,20);
		taIntro.setLineWrap(true);
		taIntro.setWrapStyleWord(true);
		taIntro.setPreferredSize(new Dimension(5,20));
		
		
		btnJoin = new JButton("가입");
		btnCancel = new JButton("취소");
		
	}
	
	private void setDisplay(){
		
		JPanel pnlMain = new JPanel(new BorderLayout());
		pnlMain.setBorder(new EmptyBorder(12, 12, 12, 12));
		
		JPanel pnlNorth = new JPanel(new BorderLayout());
		
		JPanel pnlNorthWest = new JPanel(new GridLayout(6,1,10,10));
		JPanel pnlNorthCenter = new JPanel(new GridLayout(6,1,10,10));
		JPanel pnlNorthEast = new JPanel(new GridLayout(6,1,10,10));
		
		pnlNorthWest.setPreferredSize(new Dimension(80,0));
		pnlNorthWest.add(new JLabel("아이디"));
		pnlNorthWest.add(new JLabel("이름"));
		pnlNorthWest.add(new JLabel("비밀번호"));
		pnlNorthWest.add(new JLabel("재입력"));
		pnlNorthWest.add(new JLabel("성별"));
		pnlNorthWest.add(new JLabel("자기소개"));
		
	
		
		pnlNorthCenter.add(tfId);
		pnlNorthCenter.add(tfName);
		pnlNorthCenter.add(pfPassword);
		pnlNorthCenter.add(pfRePassword);
		
		JPanel pnlGender = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlGender.add(rdMale);
		pnlGender.add(rdFemale);
		
		pnlNorthCenter.add(pnlGender);
		
		
		pnlNorthEast.add(btnDoubleCheck);
			
		
		pnlNorth.add(pnlNorthWest, BorderLayout.WEST);
		pnlNorth.add(pnlNorthCenter, BorderLayout.CENTER);
		pnlNorth.add(pnlNorthEast, BorderLayout.EAST);
		
		
		
		JPanel pnlCenter = new JPanel();		
		pnlCenter.add(taIntro);
		taIntro.setBorder(new EtchedBorder(EtchedBorder.LOWERED));

		JPanel pnlSouth = new JPanel();		
		pnlSouth.add(btnJoin);
		pnlSouth.add(btnCancel);
		
		pnlMain.add(pnlNorth, BorderLayout.NORTH);
		pnlMain.add(pnlCenter, BorderLayout.CENTER);
		pnlMain.add(pnlSouth, BorderLayout.SOUTH);
		
		add(pnlMain);
		
		
	}
	
	private void showFrame(){
		
		setTitle("회원가입");
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}

public class Quiz {

	public static void main(String[] args) {
		new Quiz1();
		new Quiz2();

	}

}
