import java.awt.*;
import javax.swing.*;

class MyUtils{

	public static void goCenter(JFrame f){

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension ScreenSize = kit.getScreenSize();
		Dimension frameSize = f.getSize();

		f.setLocation(
			(ScreenSize.width - frameSize.width)/2,
			(ScreenSize.height - frameSize.height)/2
		);
	}	
}
