package harujisaku.gui.autocomplete;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;

public abstract class AutoCompletePanel extends JPopupMenu implements MouseAdapter{
	DefaultListModel model = new DefaultListModel();
	JList list = new JList(model);
	public AutoCompletePanel(){
		super();
		setOpaque(false);
		
	}
	
	private void init(){
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFocusable(false);
		list.addMouseListener(this);
	}
	
	public JList getList(){
		return list;
	}
}