//package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class UserSelect extends JFrame {

	public UserSelect() {
		JCheckBox cbNap = new JCheckBox("����", true);
		JCheckBox cbGame = new JCheckBox("����");
		JCheckBox cbStudy = new JCheckBox("����");
		
		JPanel pnlHobby = new JPanel(new GridLayout(1, 0));
		pnlHobby.add(cbNap);
		pnlHobby.add(cbGame);
		pnlHobby.add(cbStudy);
		
		pnlHobby.setBorder(new TitledBorder(
			new LineBorder(Color.GRAY, 1), 
			"��̸� �����ϼ���"
		));
		
		JRadioButton rbtnMale = new JRadioButton("����", true);
		JRadioButton rbtnFemale = new JRadioButton("����");
		
		// ������ �׷��� ����� ����.
		ButtonGroup group = new ButtonGroup();
		group.add(rbtnMale);
		group.add(rbtnFemale);
		
		JPanel pnlGender = new JPanel(new GridLayout(1, 0));
		pnlGender.add(rbtnMale);
		pnlGender.add(rbtnFemale);
		
		pnlGender.setBorder(new TitledBorder(
			new LineBorder(Color.GRAY,  1),
			"������ �����ϼ���."
		));
		
		JPanel pnlMain = new JPanel(new BorderLayout());	
		pnlMain.setBorder(
			new EmptyBorder(10, 10, 10, 10)
		);
		
		pnlMain.add(pnlHobby, BorderLayout.NORTH);
		pnlMain.add(pnlGender, BorderLayout.CENTER);
				


		//////////////////////////


		Toolkit kit = Toolkit.getDefaultToolkit();
		ImageIcon maleIcon = new ImageIcon(
			kit.getImage("male-icon.png")
		);
		ImageIcon femaleIcon = new ImageIcon(
			kit.getImage("female-icon.png")
		);		

	
		JToggleButton btn = new JToggleButton(femaleIcon);
		btn.setSelectedIcon(maleIcon);
	


		JPanel pnlSouth = new JPanel(new BorderLayout());
		pnlSouth.add(btn, BorderLayout.NORTH);
		

		///////////////////////////


		String[] items = {
			"apple", "banana", "grape", "kiwi"	
		};
		JComboBox<String> combo = 
			new JComboBox<String>(items);
//		combo.addItem("apple");
//		combo.addItem("banana");
//		combo.addItem("grape");
//		combo.addItem("kiwi");
		
		pnlSouth.add(combo, BorderLayout.CENTER);
		


		//////////////////////////////



		String[] cars = {
			"avante",
			"sonata",
			"tico",
			"matiz"
		};
		JList<String> list = new JList<String>(cars);
		/*
		 - ���� ����
		 ListSelectionModel.SINGLE_SELECTION 
		 - ���� �׷� ����
		 ListSelectionModel.SINGLE_INTERVAL_SELECTION
		 - ���� �׷� ����
		 ListSelectionModel.MULTIPLE_INTERVAL_SELECTION
		 */
		list.setSelectionMode(
			ListSelectionModel.MULTIPLE_INTERVAL_SELECTION
		);
		// ������ ������ ��(��ũ�ѹٰ� �����ϴ� ���)
		list.setVisibleRowCount(3);
		
		// �ʺ� ����(JComboBox�� ������)
		// �Ķ���ʹ� ���׸� Ÿ�԰� �����ؾ� ��.
		list.setPrototypeCellValue("XXXXXXXXXXXXXXXXXXXXX");
		

		/////////////////////////////



		JPanel pnlList = new JPanel();

		pnlList.add(new JScrollPane(list));
		
		pnlSouth.add(pnlList, BorderLayout.SOUTH);
		
		pnlMain.add(pnlSouth, BorderLayout.SOUTH);
		
		//setContentPane(pnlMain);
		add(pnlMain);


		showFrame();
	}
	private void showFrame() {
		setTitle("UserSelect");
		pack();
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}	
	public static void main(String[] args) {
		new UserSelect();
	}
}
