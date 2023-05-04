package giaodien;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class cusTable extends JTable{

	public cusTable() {
		super();

		setFont(new Font("Open Sans SemiBold", Font.PLAIN, 15));
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setRowHeight(40);
		setShowVerticalLines(false);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setDefaultEditor(Object.class, null);
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)this.getDefaultRenderer(Object.class);
//	    renderer.setHorizontalAlignment( SwingConstants.CENTER );
	    
		JTableHeader header = getTableHeader();
		header.setBackground(new Color(175, 238, 238));
		header.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 18));
		header.setBorder(new MatteBorder(3, 2, 0, 2, (Color) new Color(0, 0, 0)));
		setSelectionBackground(Color.CYAN);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	}
	public void popUp(int i)
	{
		if(i==1) {
			JPopupMenu popupMenu = new JPopupMenu();
			JMenuItem menuItemRemove = new JMenuItem("DELETE");
			JMenuItem menuItemRemoveAll = new JMenuItem("EDIT");
			popupMenu.add(menuItemRemove);
			popupMenu.add(menuItemRemoveAll);
			this.setComponentPopupMenu(popupMenu);
		}
	}
	
    


}
