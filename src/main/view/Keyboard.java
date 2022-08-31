package main.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.model.Memory;

@SuppressWarnings("serial")
public class Keyboard extends JPanel implements ActionListener {

	private final Color COR_CINZA_ESCURO = new Color(60, 60, 60);
	private final Color COR_CINZA_CLARO = new Color(99, 99, 99);
	private final Color COR_AZUL = new Color(65, 105, 225);
	
	public Keyboard() {
				
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints(); 
		setLayout(layout);
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH; 
		
        //First line
		c.gridwidth = 3;
		addButton("AC", COR_CINZA_ESCURO, c, 0, 0);
		c.gridwidth = 1;
		addButton("/", COR_AZUL, c, 3, 0);
		
		
		//Second line
		addButton("7", COR_CINZA_CLARO, c, 0, 1);
		addButton("8", COR_CINZA_CLARO, c, 1, 1);
		addButton("9", COR_CINZA_CLARO, c, 2, 1);
		addButton("x", COR_AZUL, c, 3, 1);
		
		//Third line
		addButton("4", COR_CINZA_CLARO, c, 0, 2);
		addButton("5", COR_CINZA_CLARO, c, 1, 2);
		addButton("6", COR_CINZA_CLARO, c, 2, 2);
		addButton("-", COR_AZUL, c, 3, 2);
		
		//Fourth line
		addButton("1", COR_CINZA_CLARO, c, 0, 3);
		addButton("2", COR_CINZA_CLARO, c, 1, 3);
		addButton("3", COR_CINZA_CLARO, c, 2, 3);
		addButton("+", COR_AZUL, c, 3, 3);
	
		//Fifth line
		c.gridwidth = 2;
		addButton("0", COR_CINZA_CLARO, c, 0, 4);
		c.gridwidth = 1;
		addButton(",", COR_CINZA_CLARO, c, 2, 4);
		addButton("=", COR_AZUL, c, 3, 4);
		
	}

	private void addButton (String text, Color color, GridBagConstraints c, int x, int y) {
		c.gridx = x;
		c.gridy = y;
		Button button = new Button(text, color);
		button.addActionListener(this);
		add(button, c);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton button = (JButton) e.getSource();
            Memory.getMemory().commandProcess(button.getText());
		}	
	}
}
