import java.awt.*;
import javax.swing.*;

public class JFameEx3 {
	public static void main(String[] args) {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		System.out.println(screenSize);


		JFrame f = new JFrame();
		
		int win_width = screenSize.width;
		int win_height = screenSize.height;


		f.setBounds((win_width-300)/2,(win_height-400)/2,300,400);

		f.setVisible(true);

	}
}
