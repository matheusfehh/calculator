package main.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

import main.model.Memory;
import main.model.ObservedMemory;

import java.awt.FlowLayout;

public class Display extends JPanel implements ObservedMemory {
    
    private final JLabel label;

    public Display() {

        Memory.getMemory().addObservers(this);

        setBackground(new ColorUIResource(46, 49, 50));
        label = new JLabel(Memory.getMemory().getCurrentText());
        label.setForeground(new ColorUIResource(255, 255, 255));
        label.setFont(new FontUIResource("courier", ALLBITS, 30));

        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 25));

        add(label);

    }

    @Override
    public void alteredValue(String newValue) {
        label.setText(newValue);
    }

}
