package harujisaku.gui.autocomplete;

import java.awt.Point;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.JPopupMenu;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.text.JTextComponent;

public abstract class AutoCompletePanel extends JPopupMenu implements MouseListener{
	DefaultListModel model = new DefaultListModel();
	JList list = new JList(model);
	JTextComponent textpane;
	public AutoCompletePanel(JTextComponent textpane){
		super();
		this.textpane=textpane;
		setOpaque(false);
		init();
	}
	
	public void show(Point p){
		final int position = textpane.getCaretPosition();
		setVisible(true);
		setOpaque(true);
		add(list);
		show(textpane,p.x,textpane.getBaseline(0,0)+p.y+15);
		list.setSelectedIndex(0);
		textpane.setCaretPosition(position);
	}
	
	private void init(){
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFocusable(false);
		list.addMouseListener(this);
		setVisible(false);
	}
	
	public JList getList(){
		return list;
	}
	
	@Override
	public void mouseClicked(MouseEvent e){}
	@Override
	public void mouseEntered(MouseEvent e){}
	@Override
	public void mouseExited(MouseEvent e){}
	@Override
	public void mousePressed(MouseEvent e){}
	@Override
	public void mouseReleased(MouseEvent e){}
}