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
		chkCombo = new JCheckBox("�޺�");
		chkPotato = new JCheckBox("��������");
		chkBulgogi = new JCheckBox("�Ұ��");
				
		rdPimento = new JRadioButton("�Ǹ�");
		rdCheese = new JRadioButton("ġ��");
		rdPeperoni = new JRadioButton("����δ�");
		rdbacon = new JRadioButton("������");
		
		ButtonGroup Topping = new ButtonGroup();
		Topping.add(rdPimento);
		Topping.add(rdCheese);
		Topping.add(rdPeperoni);
		Topping.add(rdbacon);
		
		chkSmall = new JCheckBox("small");
		chkMedium = new JCheckBox("medium");
		chkLarge = new JCheckBox("large");
		
		btnOrder = new JButton("�ֹ�");
		btnCancel = new JButton("���");		
	}
	private void setDisplay(){
		
		JLabel lblNorth = new JLabel("�ڹ����ڿ� ���Ű��� ȯ���մϴ�.",JLabel.CENTER);
		
		//
		
		JPanel pnlCenter = new JPanel(new GridLayout(1,0));
		pnlCenter.setBorder(new EmptyBorder(0, 10, 0, 10));
		
		JPanel pnlSelect1 = new JPanel(new GridLayout(0, 1));
		JPanel pnlSelect2 = new JPanel(new GridLayout(0, 1));
		JPanel pnlSelect3 = new JPanel(new GridLayout(0, 1));
		
		
		
		pnlSelect1.add(chkCombo);
		pnlSelect1.add(chkPotato);
		pnlSelect1.add(chkBulgogi);
		pnlSelect1.setBorder(new TitledBorder("����"));
		
		pnlSelect2.add(rdPimento);
		pnlSelect2.add(rdCheese);
		pnlSelect2.add(rdPeperoni);
		pnlSelect2.add(rdbacon);
		pnlSelect2.setBorder(new TitledBorder("����"));
		
		pnlSelect3.add(chkSmall);
		pnlSelect3.add(chkMedium);
		pnlSelect3.add(chkLarge);
		pnlSelect3.setBorder(new TitledBorder("ũ��"));
		
		
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
		
		setTitle("�����ֹ�");
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
		
		btnDoubleCheck = new JButton("�ߺ��˻�");
		
		rdMale = new JRadioButton("����",true);
		rdFemale = new JRadioButton("����");
		
		ButtonGroup groupGender = new ButtonGroup();
		groupGender.add(rdMale);
		groupGender.add(rdFemale);
		
		taIntro = new JTextArea(5,20);
		taIntro.setLineWrap(true);
		taIntro.setWrapStyleWord(true);
		taIntro.setPreferredSize(new Dimension(5,20));
		
		
		btnJoin = new JButton("����");
		btnCancel = new JButton("���");
		
	}
	
	private void setDisplay(){
		
		JPanel pnlMain = new JPanel(new BorderLayout());
		pnlMain.setBorder(new EmptyBorder(12, 12, 12, 12));
		
		JPanel pnlNorth = new JPanel(new BorderLayout());
		
		JPanel pnlNorthWest = new JPanel(new GridLayout(6,1,10,10));
		JPanel pnlNorthCenter = new JPanel(new GridLayout(6,1,10,10));
		JPanel pnlNorthEast = new JPanel(new GridLayout(6,1,10,10));
		
		pnlNorthWest.setPreferredSize(new Dimension(80,0));
		pnlNorthWest.add(new JLabel("���̵�"));
		pnlNorthWest.add(new JLabel("�̸�"));
		pnlNorthWest.add(new JLabel("��й�ȣ"));
		pnlNorthWest.add(new JLabel("���Է�"));
		pnlNorthWest.add(new JLabel("����"));
		pnlNorthWest.add(new JLabel("�ڱ�Ұ�"));
		
	
		
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
		
		setTitle("ȸ������");
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
