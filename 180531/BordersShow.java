//package kr.ac.green;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

class MyFrame extends JFrame{
	public MyFrame(){
		init();
		setDisplay();
		showFrame();
	}
	private void init(){
		setLayout(new GridLayout(0, 2, 5, 5));
		
	}
	private void setDisplay(){
		JLabel lbl;
		
		
		lbl = new JLabel("EmptyBorder", JLabel.CENTER);
		
		// up, left, down, right
		lbl.setBorder(new EmptyBorder(10, 20, 30, 40));		
//		Insets insets = new Insets(10, 20, 30, 40);
//		lbl.setBorder(new EmptyBorder(insets));		
		add(lbl);
		
		lbl = new JLabel("LineBorder", JLabel.CENTER);
		// color, [thickness]
		lbl.setBorder(new LineBorder(Color.RED, 5));		
		add(lbl);
		
		lbl = new JLabel("EtchedBorder(RAISED)", JLabel.CENTER);
		// EtchType
		lbl.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		add(lbl);
		
		lbl = new JLabel("EtchedBorder(LOWERED)", JLabel.CENTER);
		lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		add(lbl);
		
		lbl = new JLabel("BevelBorder(RAISED)", JLabel.CENTER);
		
		lbl.setBorder(new BevelBorder(BevelBorder.RAISED));
		add(lbl);
		
		lbl = new JLabel("BevelBorder(LOWERED)", JLabel.CENTER);
		lbl.setBorder(new BevelBorder(BevelBorder.LOWERED));
		add(lbl);
		
		lbl = new JLabel("TitledBorder", JLabel.CENTER);
		lbl.setBorder(new TitledBorder("Title"));
		add(lbl);
		
		lbl = new JLabel("Titled + Titled", JLabel.CENTER);
		lbl.setBorder(new TitledBorder(new TitledBorder(new LineBorder(Color.black),"Title",TitledBorder.LEFT,TitledBorder.ABOVE_TOP),"Title",TitledBorder.RIGHT,TitledBorder.BELOW_BOTTOM));
		add(lbl);	
		
		
		lbl = new JLabel("Titled+Line(TitleFontModified)", JLabel.CENTER);
		// Border, Title, titleJustification(Ⱦ), titlePosition(��), TitleFont, TitleColor
		// Ⱦ(LEFT, RIGTH, CENTER)
		// ��(TOP, BOTTOM, ABOVE_TOP, BELOW_TOP, ABOVE_BOTTOM, BELOW_BOTTOM)
		lbl.setBorder(new TitledBorder(
				new LineBorder(Color.blue,2),
				"Title",
				TitledBorder.CENTER,
				TitledBorder.ABOVE_TOP,
				new Font(Font.DIALOG,Font.ITALIC,20),
				Color.red
				));
		
		add(lbl);		
		
		
	
		
		
	}
	
	private void showFrame(){
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}

public class BordersShow {

	public static void main(String[] args) {
		new MyFrame();

	}

}
