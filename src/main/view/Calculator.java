package main.view;

import javax.swing.JFrame;
import javax.swing.plaf.DimensionUIResource;

import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class Calculator extends JFrame {

	public Calculator() {
	
		organizeLayout();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(232, 320);
		setTitle("Cauculadora Java");
		setVisible(true);
		setLocationRelativeTo(null);
		
	}
	
	private void organizeLayout() {
		setLayout(new BorderLayout());
		
		Display display = new Display();
		display.setPreferredSize(new DimensionUIResource(233, 60));
		add(display, BorderLayout.NORTH);
		
		Keyboard keyboard = new Keyboard();
		keyboard.setPreferredSize(new DimensionUIResource(233, 260));
		add(keyboard, BorderLayout.CENTER);
		
	}

	public static void main(String[] args) {
		
		new Calculator();
		
	}
	
}
