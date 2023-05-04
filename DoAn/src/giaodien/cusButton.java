package giaodien;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class cusButton extends JButton implements ActionListener, MouseListener {
    public cusButton(String text) {
        super(text);
        addActionListener(this);
        addMouseListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
    }
    
    public void mouseEntered(MouseEvent e) {
    	this.setBackground(new Color(87, 197, 182));
    	this.setForeground(Color.WHITE);
    }
    
    public void mouseExited(MouseEvent e) {
    	this.setBackground(Color.WHITE);
    	this.setForeground(Color.BLACK);
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

	

