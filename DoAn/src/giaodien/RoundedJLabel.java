package giaodien;
import java.awt.*;
import javax.swing.*;

public class RoundedJLabel extends JLabel {

    private int radius;

    public RoundedJLabel(String text, int radius) {
        super(text);
        this.radius = radius;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        size.width += radius * 2;
        size.height += radius * 2;
        return size;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        repaint();
    }
}