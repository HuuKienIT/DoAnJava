package giaodien;
import javax.swing.*;
import java.awt.*;

public class cusComboBox extends JComboBox {
    private Color backgroundColor;
    private Font font;

    
    public cusComboBox() {
        super();
        backgroundColor = Color.WHITE; 
        font = getFont(); 
    }
    
    public cusComboBox(Object[] items) {
        super(items);
        backgroundColor = Color.WHITE; 
        font = getFont(); 
    }

    public void setBackgroundColor(Color color) {
        backgroundColor = color;
        setBackground(backgroundColor);
    }

    public void setFont(Font font) {
        this.font = font;
        super.setFont(font);
    }
}