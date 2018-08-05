import java.awt.*;
import javax.swing.*;
/*
java.lang.Object 
java.awt.Component 
java.awt.Container 
java.awt.Window 
java.awt.Frame 
javax.swing.JFrame 
*/


public class JFrameEx1 {
	public static void main(String[] args) {
		JFrame f = new JFrame("�׽�Ʈâ�Դϴ�.");
		// f.setTitle("�׽�Ʈ â�Դϴ�");
		// Swing ���� �޼ҵ���� �ձ��ڰ� J

		// f.setSize(600,600);
		//������ �ȼ�
		Dimension size = new Dimension(600,600);
		System.out.println(size.width); 
		//��������� public �̶� �������� ���� 
		System.out.println(size.height);
		f.setSize(size);
		// import java.awt.*

		// f.setLocation(600,300);
		Point location = new Point(200,200);
		//��������� public �̶� �������� ���� 
		f.setLocation(location);
		
		Dimension frameSize = f.getSize();
		Point frameLocation = f.getLocation();
		System.out.println(frameSize);
		System.out.println(frameLocation);

		JButton button = new JButton(frameSize.toString() + frameLocation.toString());
		f.add(button);
		//JLabel label = new JLabel("��");
		//f.add(label);
		f.pack();
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
			EXIT_ON_CLOSE
				��ü ���α׷� ����
			DISPOSE_ON_CLOSE
				�ش� ���α׷� ����
			HIDE_ON_CLOSE
				���ü� ����(default)
			DO_NOTHING_ON_CLOSE
				�ƹ��͵� ����
		*/

		f.setVisible(true);
		// ���� ���� ��ġ



	}
}
