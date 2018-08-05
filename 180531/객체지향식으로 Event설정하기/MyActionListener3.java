package kr.ac.green;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener3 implements ActionListener {
	
	private IWorker worker;
	
	public MyActionListener3(IWorker worker) {
		this.worker = worker; 
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		worker.todo();
	}
}







