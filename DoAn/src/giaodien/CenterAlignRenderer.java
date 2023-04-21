package giaodien;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class CenterAlignRenderer extends DefaultTableCellRenderer{
	 public CenterAlignRenderer() {
	        setHorizontalAlignment(SwingConstants.CENTER); // Set the alignment of the cell contents to the center
	    }
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	    }
}
