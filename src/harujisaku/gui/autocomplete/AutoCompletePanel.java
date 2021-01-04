package harujisaku.gui.autocomplete;

import java.util.*;

import java.awt.Point;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.JPopupMenu;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.text.JTextComponent;
import javax.swing.text.BadLocationException;
/**
 * 自動補完をするためのポップアップメニューです.
 */
public abstract class AutoCompletePanel extends JPopupMenu implements MouseListener{
	JTextComponent textpane;
	/**
	 * デフォルトコンストラクタ
	 * @param textpane 自動補完をする対象
	 */
	public AutoCompletePanel(JTextComponent textpane){
		super();
		this.textpane=textpane;
		setOpaque(false);
		init();
	}
	/**
	 * 表示する
	 * @param list 表示する保管文字列の配列
	 */
	public void show(List<String> list){
		final int position = textpane.getCaretPosition();
		Point p = new Point(0,0);
		try {
			p=textpane.modelToView(position).getLocation();
		} catch(BadLocationException e) {
			e.printStackTrace();
		}
		
		setVisible(true);
		setOpaque(true);
		JList jlist = new JList(list.toArray(new String[list.size()]));
		add(jlist);
		show(textpane,p.x,textpane.getBaseline(0,0)+p.y+15);
		jlist.setSelectedIndex(0);
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlist.setFocusable(false);
		textpane.setCaretPosition(position);
	}
	
	private void init(){
		setVisible(false);
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