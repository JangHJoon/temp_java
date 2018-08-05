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
		JFrame f = new JFrame("테스트창입니다.");
		// f.setTitle("테스트 창입니다");
		// Swing 관련 메소드들은 앞글자가 J

		// f.setSize(600,600);
		//단위가 픽셀
		Dimension size = new Dimension(600,600);
		System.out.println(size.width); 
		//멤버변수가 public 이라서 직접접근 가능 
		System.out.println(size.height);
		f.setSize(size);
		// import java.awt.*

		// f.setLocation(600,300);
		Point location = new Point(200,200);
		//멤버변수가 public 이라서 직접접근 가능 
		f.setLocation(location);
		
		Dimension frameSize = f.getSize();
		Point frameLocation = f.getLocation();
		System.out.println(frameSize);
		System.out.println(frameLocation);

		JButton button = new JButton(frameSize.toString() + frameLocation.toString());
		f.add(button);
		//JLabel label = new JLabel("라벨");
		//f.add(label);
		f.pack();
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
			EXIT_ON_CLOSE
				전체 프로그램 종료
			DISPOSE_ON_CLOSE
				해당 프로그램 종료
			HIDE_ON_CLOSE
				가시성 제거(default)
			DO_NOTHING_ON_CLOSE
				아무것도 안함
		*/

		f.setVisible(true);
		// 보통 끝에 위치



	}
}
