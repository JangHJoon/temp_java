import java.awt.*;
import javax.swing.*;
class JFrameEx2 {
	public static void main(String[] args) {

		JFrame f = new JFrame("내가 만든 창");

		//f.setSize(400,300);
		//f.setLocation(200,100);
		f.setBounds(200,100, 400,300);

		//Rectangle r = new Rectangle(200,100,400,300);
		//f.setBounds(r);

		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		f.setVisible(true);

	}
}
