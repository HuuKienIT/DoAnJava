package giaodien;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.border.AbstractBorder;

public class RoundedBorder extends AbstractBorder {
    private static final long serialVersionUID = 1L;

    private final Color color;
    private final int radius;

    public RoundedBorder(Color color, int radius) {
        this.color = color;
        this.radius = radius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(color);

        int x1 = x + radius;
        int y1 = y + radius;
        int x2 = x + width - radius - 1;
        int y2 = y + height - radius - 1;

        g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        g2d.drawLine(x1, y, x2, y);
        g2d.drawLine(x1, y2, x2, y2);
        g2d.drawLine(x, y1, x, y2);
        g2d.drawLine(x2, y1, x2, y2);

        g2d.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(radius, radius, radius, radius);
    }
}