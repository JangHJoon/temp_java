//package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

// CTRL + SHIFT + O
public class BorderEx extends JFrame {

	private JPanel pnlBorders =	new JPanel(
		new GridLayout(0, 1, 0, 10)
	);

	private Font font =	new Font(
		Font.DIALOG, Font.BOLD, 15
	);

	public BorderEx() {
		// ��, ����, �Ʒ�, ������ 
		Insets insets = new Insets(20, 20, 20, 20);
		pnlBorders.setBorder(
			new EmptyBorder(insets)
		);
	
		addLabel("Default", null);
		
		TitledBorder tBorder = new TitledBorder("Title");
		// Ÿ��Ʋ ��Ʈ ����
		tBorder.setTitleFont(
			new Font(Font.SERIF, Font.ITALIC, 20)
		);	
		// Ÿ��Ʋ ���� ����
		tBorder.setTitleColor(Color.RED);
		addLabel("TitledBorder(Default)", tBorder);
		
		tBorder = new TitledBorder(
			// 1. ������ü, 2. Ÿ��Ʋ ����
			new LineBorder(Color.GRAY, 1), "Title"
		);
		addLabel("Titled + Line", tBorder);
		
		tBorder = new TitledBorder(
			new LineBorder(Color.GRAY, 1), "Center title"
		);
		// Ⱦ(LEFT, RIGTH, CENTER)
		tBorder.setTitleJustification(TitledBorder.CENTER);
		addLabel("TitledBorder", tBorder);
		
		tBorder = new TitledBorder(
			new LineBorder(Color.GRAY, 1), "Bottom title"
		);
		
		// ABOVE : ����
		// BELOW : ���Ʒ�
		tBorder.setTitleJustification(TitledBorder.RIGHT);
		tBorder.setTitlePosition(TitledBorder.ABOVE_TOP);
		addLabel("TitledBorder", tBorder);
		
		LineBorder lBorder = new LineBorder(Color.GRAY, 1);
		addLabel("LineBorder", lBorder);
		
		TitledBorder innerBorder = new TitledBorder(
			new LineBorder(Color.GRAY,1), "second"
		);

		innerBorder.setTitlePosition(TitledBorder.BOTTOM);
		
		tBorder = new TitledBorder(
			innerBorder,
			"first"
		);

		addLabel("Titled + Titled", tBorder);
		
		
		EtchedBorder eBorder = new EtchedBorder(
			EtchedBorder.LOWERED
		);
		addLabel("EtchedBorder(LOWERED)", eBorder);
		
		eBorder = new EtchedBorder(EtchedBorder.RAISED);
		addLabel("EtchedBorder(RAISED", eBorder);
		
		BevelBorder bBorder = new BevelBorder(
			BevelBorder.LOWERED
		);
		addLabel("BevelBorder(LOWERED)", bBorder);
		
		bBorder = new BevelBorder(
			BevelBorder.RAISED
		);
		addLabel("BevelBorder(RAISED)", bBorder);
		
		JScrollPane pane = new JScrollPane(pnlBorders);
		
		JPanel pnlNorth = new JPanel();
		JTextField tfInput = new JTextField(20);
		tfInput.setBorder(
			new TitledBorder(
				new LineBorder(Color.GRAY, 1),
				"�ּҸ� �Է��ϼ���."
			)
		);
		pnlNorth.add(tfInput);
		pnlNorth.setBackground(Color.WHITE);
//		pnlNorth.setBorder(
//			new TitledBorder(
//				new EmptyBorder(0,0,0,0),	
//				"�ּҸ� �Է��ϼ�"
//			)
//		);
		add(pnlNorth, BorderLayout.NORTH);
		add(pane, BorderLayout.CENTER);		
		showFrame();
	}
	
	private void addLabel(String lblText, AbstractBorder border) { //Border���� ���� ��ü AbstractBorder
		JLabel lbl = new JLabel(lblText, JLabel.CENTER);
		lbl.setFont(font);
		lbl.setBorder(border);
		pnlBorders.add(lbl);
	}

	private void showFrame() {
		setTitle("Border Ex");
		setSize(300, 400);
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BorderEx();
	}
}
