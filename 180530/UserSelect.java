package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class UserSelect extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2642611390791005841L;

	public UserSelect(){
		
		JCheckBox cbNap = new JCheckBox("낮잠", true);
		JCheckBox cbGame = new JCheckBox("게임");
		JCheckBox cbStudy = new JCheckBox("공부");
	
		
		JPanel pnlHobby = new JPanel(new GridLayout(1, 0));
		pnlHobby.add(cbNap);
		pnlHobby.add(cbGame);
		pnlHobby.add(cbStudy);
		
		pnlHobby.setBorder(
				new TitledBorder( new LineBorder(Color.GRAY, 1)
				 				 ,"취미를 선택하세요")
				);		
		
		JPanel pnlMain = new JPanel(new BorderLayout());
		pnlMain.setBorder(new EmptyBorder(10, 10, 10, 10));

		setContentPane(pnlMain);
		add(pnlHobby, BorderLayout.NORTH);
		
		
		
		
		
		JRadioButton rbtnMale = new JRadioButton("남자",true);
		JRadioButton rbtnFemale = new JRadioButton("여자");
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbtnMale);
		group.add(rbtnFemale);
		
		JPanel pnlGender = new JPanel(new GridLayout(1, 0));
		pnlGender.add(rbtnMale);
		pnlGender.add(rbtnFemale);
		
		pnlGender.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1), "성별을 선택하세요"));
		
		add(pnlGender);
		
		
		
		
		
		showFrame();
		
	}
	private void showFrame(){
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
