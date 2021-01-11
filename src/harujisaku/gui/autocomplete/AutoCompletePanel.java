package harujisaku.gui.autocomplete;

import java.util.*;

import java.awt.Point;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.JPopupMenu;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;
import javax.swing.text.BadLocationException;
/**
 * 自動補完をするためのポップアップメニューです.
 */
public abstract class AutoCompletePanel extends JPopupMenu{
	JTextComponent textpane;
	DefaultListModel model = new DefaultListModel();
	JList jlist= new JList(model);
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
	public void show(String[] list){
		final int position = textpane.getCaretPosition();
		Point p = new Point(0,0);
		try {
			p=textpane.modelToView(position).getLocation();
		} catch(BadLocationException e) {
			e.printStackTrace();
		}
		setVisible(true);
		setOpaque(true);
		System.out.println(Arrays.toString(list));
		int selectedIndex = jlist.getSelectedIndex();
		model.clear();
		for (final String str :list ) {
			model.addElement(str);
		}
		add(jlist);
		show(textpane,p.x,textpane.getBaseline(0,0)+p.y+15);
		if (selectedIndex==-1) {
			jlist.setSelectedIndex(0);
		}else{
			jlist.setSelectedIndex(selectedIndex);
		}
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlist.setFocusable(false);
		textpane.setCaretPosition(position);
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				textpane.requestFocusInWindow();
			}
		});
	}

	@Override
	public void hide(){
		model.clear();
		setVisible(false);
	}

	private void init(){
		setVisible(false);
	}

	public int getSelectedIndex(){
		return jlist.getSelectedIndex();
	}

	public JList getJList(){
		return jlist;
	}

	public void setSelectedIndex(int index){
		jlist.setSelectedIndex(index);
	}

	public void setSelectedLower(){
		jlist.setSelectedIndex(Math.min(jlist.getModel().getSize()-1,jlist.getSelectedIndex()+1));
	}

	public void setSelectedUpper(){
		jlist.setSelectedIndex(Math.max(jlist.getSelectedIndex()-1,0));
	}
}
