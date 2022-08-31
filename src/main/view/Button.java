package main.view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.plaf.FontUIResource;

import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class Button extends JButton {
    
    public Button(String text, Color color) {

        setText(text);
        setFont(new FontUIResource("courier", Font.PLAIN, 25));
        setOpaque(true);
        setBackground(color);
        setForeground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }

}
